package org.example;

import java.util.Random;

public interface ImplNicknameGenerator {
    static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }

    static boolean isPalindrom(String nickname) {
        return nickname.equals(new StringBuilder(nickname).reverse().toString());
    }

    static boolean isOneChar(String nickname) {
        for (int i = 1; i < nickname.length(); i++) {
            if (nickname.charAt(i) != nickname.charAt(i - 1))
                return false;
        }
        return true;
    }

    static boolean isAscendingOrder(String nickname) {
        for (int i = 1; i < nickname.length(); i++) {
            if (nickname.charAt(i) < nickname.charAt(i - 1))
                return false;
        }
        return true;
    }
}
