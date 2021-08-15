package net.ibxnjadev.kruby.core.java;

public enum JavaVersion {
    JAVA_7, JAVA_8, JAVA_11, JAVA_16;

    public static JavaVersion parse(int version) {
        switch (version) {
            case 7:
                return JavaVersion.JAVA_7;
            case 8:
                return JavaVersion.JAVA_8;
            case 11:
                return JavaVersion.JAVA_11;
            default:
                return JavaVersion.JAVA_16;
        }
    }

}
