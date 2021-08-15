package net.ibxnjadev.kruby.core.java;

public enum JavaVersion {
    V_7, V_8, V_11, V_16;

    public static JavaVersion parse(int version) {
        switch (version) {
            case 7:
                return JavaVersion.V_7;
            case 8:
                return JavaVersion.V_8;
            case 11:
                return JavaVersion.V_11;
            default:
                return JavaVersion.V_16;
        }
    }

}
