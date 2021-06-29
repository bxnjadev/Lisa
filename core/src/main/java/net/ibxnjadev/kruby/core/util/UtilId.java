package net.ibxnjadev.kruby.core.util;

import java.util.Random;

public class UtilId {

    private static final Random RANDOM = new Random();

    public static String randomId() {
       return randomId(6);
    }

    public static String randomId(int size) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < size; i++) {
            stringBuilder.append(randomChar());
        }

        return stringBuilder.toString();
    }

    public static char randomChar() {
        int value = RANDOM.nextInt(3);
        switch (value) {
            case 0:
                return (char) getRandomNumberInRange(48, 57);
            case 1:
                return (char) getRandomNumberInRange(65, 90);
            default:
                return (char) getRandomNumberInRange(97, 122);
        }
    }

    private static int getRandomNumberInRange(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }


}
