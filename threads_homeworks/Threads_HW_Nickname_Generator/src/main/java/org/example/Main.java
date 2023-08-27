package org.example;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static AtomicInteger counter3 = new AtomicInteger();
    public static AtomicInteger counter4 = new AtomicInteger();
    public static AtomicInteger counter5 = new AtomicInteger();

    public static void incrementCounter(int textLength) {
        if (textLength == 3) {
            counter3.getAndIncrement();
        } else if (textLength == 4) {
            counter4.getAndIncrement();
        } else {
            counter5.getAndIncrement();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        String[] texts = new String[100_000];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = ImplNicknameGenerator.generateText("abc", 3 + random.nextInt(3));
        }

        Thread palindrom = new Thread(() -> {
            for (String text : texts) {
                if (ImplNicknameGenerator.isPalindrom(text) && !ImplNicknameGenerator.isOneChar(text)) {
                    incrementCounter(text.length());
                }
            }
        });
        Thread oneChar = new Thread(() -> {
            for (String text : texts) {
                if (ImplNicknameGenerator.isOneChar(text)) {
                    incrementCounter(text.length());
                }
            }
        });
        Thread ascendingOrder = new Thread(() -> {
            for (String text : texts) {
                if (ImplNicknameGenerator.isAscendingOrder(text) && !ImplNicknameGenerator.isOneChar(text)) {
                    incrementCounter(text.length());
                }
            }
        });

        ascendingOrder.start();
        oneChar.join();
        ascendingOrder.join();
        palindrom.join();

        System.out.println("Красивых слов с длинной 3 -> " + counter3);
        System.out.println("Красивых слов с длинной 4 -> " + counter4);
        System.out.println("Красивых слов с длинной 5 -> " + counter5);

    }
}