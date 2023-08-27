package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;


public class Main {

    private static final int STRING_LENGTH = 100;
    private static final int STRING_COUNT = 1000;
    private static final String LETTERS = "abc";

    //Метод подсчета совпадений с заданным символом в строке.
    public static int countChars(String str, char ch) {
        return (int) str.chars()
                .filter(c -> c == ch)
                .count();
    }

    //Метод для получения строки с наибольшим количеством совпадений с заданным символом.
    public static String GetStringWithMoreChars(ArrayBlockingQueue<String> array, char ch) {
        int count = 0;
        String str = null;
        for (String element : array) {
            if (count < countChars(element, ch)) {
                str = element;
            }
        }
        return str;
    }

    //Генерация текста
    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> a = new ArrayBlockingQueue<>(STRING_COUNT);
        ArrayBlockingQueue<String> b = new ArrayBlockingQueue<>(STRING_COUNT);
        ArrayBlockingQueue<String> c = new ArrayBlockingQueue<>(STRING_COUNT);

        Thread generate = new Thread(() -> {
            System.out.println("Приступаем к генерации строк.");
            for (int i = 0; i < STRING_COUNT; i++) {
                try {
                    a.put(generateText(LETTERS, STRING_LENGTH));
                    b.put(generateText(LETTERS, STRING_LENGTH));
                    c.put(generateText(LETTERS, STRING_LENGTH));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Генерация успешно завершена.");
        });
        generate.start();
        generate.join();

        ArrayList<Thread> threads = new ArrayList<>();
        threads.add(new Thread(() -> {
            String str = GetStringWithMoreChars(a, 'a');
            System.out.println("Символ 'a' больше всего раз повторяется в данной строке: " + str + " . Количество повторений символа: " + countChars(str, 'a'));
        }));

        threads.add(new Thread(() -> {
            String str = GetStringWithMoreChars(b, 'b');
            System.out.println("Символ 'b' больше всего раз повторяется в данной строке: " + str + " . Количество повторений символа: " + countChars(str, 'b'));
        }));

        threads.add(new Thread(() -> {
            String str = GetStringWithMoreChars(c, 'c');
            System.out.println("Символ 'c' больше всего раз повторяется в данной строке: " + str + " . Количество повторений символа: " + countChars(str, 'c'));
        }));

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

    }
}