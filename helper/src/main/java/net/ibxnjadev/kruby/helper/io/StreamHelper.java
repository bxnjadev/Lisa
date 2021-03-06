package net.ibxnjadev.kruby.helper.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class StreamHelper {

    private static final byte[] BUFFER = new byte[1024];

    public static void copyStream(InputStream inputStream, OutputStream outputStream) {
        int byteRead;

        try {
            while ((byteRead = inputStream.read(BUFFER)) != -1) {
                outputStream.write(BUFFER, 0, byteRead);
            }

            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static InputStream getResource(String path) {
        return StreamHelper
                .class
                .getClassLoader()
                .getResourceAsStream(path);
    }

    public static InputStream transform(String string){
        return new ByteArrayInputStream(string.getBytes(StandardCharsets.UTF_8));
    }

}
