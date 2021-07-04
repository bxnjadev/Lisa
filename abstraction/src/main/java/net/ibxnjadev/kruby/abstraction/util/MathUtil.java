package net.ibxnjadev.kruby.abstraction.util;

public class MathUtil {

    public static int getRandomNumberInRange(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }


}
