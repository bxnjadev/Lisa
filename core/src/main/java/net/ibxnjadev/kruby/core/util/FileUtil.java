package net.ibxnjadev.kruby.core.util;

import java.io.File;
import java.io.IOException;
import java.util.function.Consumer;

public class FileUtil {


    public static void createFolderAndExecute(String folderName, Consumer<File> consumer) throws IOException {
        createFolderAndExecute(null, folderName, consumer);
    }

    public static void createFileAndExecute(String folderName, Consumer<File> consumer) throws IOException {
        createFileAndExecute(null, folderName, consumer);
    }

    public static void createFolderAndExecute(File fileBase, String folderName, Consumer<File> consumer) throws IOException {
        createGenericFileAndExecute(fileBase, folderName, consumer, TypeFile.FOLDER);
    }

    public static void createFileAndExecute(File fileBase, String fileName, Consumer<File> consumer) throws IOException {
        createGenericFileAndExecute(fileBase, fileName, consumer, TypeFile.NORMAL_FILE);
    }

    private static void createGenericFileAndExecute(File fileBase, String folderName, Consumer<File> consumer, TypeFile typeFile) throws IOException {
        File genericFile = new File(fileBase, folderName);

        if (!genericFile.exists()) {
            createFile(genericFile, typeFile);
            consumer.accept(genericFile);
        }
    }

    private static void createFile(File genericFile, TypeFile typeFile) {
        try {
            if (typeFile == TypeFile.NORMAL_FILE) {
                genericFile.createNewFile();
                return;
            }
            genericFile.mkdirs();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static enum TypeFile {
        NORMAL_FILE, FOLDER;
    }

}
