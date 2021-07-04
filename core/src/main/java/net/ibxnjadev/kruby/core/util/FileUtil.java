package net.ibxnjadev.kruby.core.util;

import java.io.File;
import java.io.IOException;

public class FileUtil {

    public static void createFolderAndExecute(File fileBase, String folderName, Executor executor) {
        createGenericFileAndExecute(fileBase, folderName, executor, TypeFile.FOLDER);
    }

    public static void createFileAndExecute(File fileBase, String folderName, Executor executor) {
        createGenericFileAndExecute(fileBase, folderName, executor, TypeFile.NORMAL_FILE);
    }

    private static void createGenericFileAndExecute(File fileBase, String folderName, Executor executor, TypeFile typeFile) {
        File genericFile = new File(fileBase, folderName);

        if (genericFile.exists()) {
            createFile(genericFile, typeFile);
            executor.execute();
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

    enum TypeFile {
        NORMAL_FILE, FOLDER;
    }

}
