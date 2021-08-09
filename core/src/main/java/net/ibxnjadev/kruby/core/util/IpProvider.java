package net.ibxnjadev.kruby.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class IpProvider {

    private static final String REQUEST_URL = "https://checkip.amazonaws.com";

    public static String provideIp() {
        URL url = null;

        try {
            url = new URL(REQUEST_URL);

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    url.openStream()));

            return in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

}
