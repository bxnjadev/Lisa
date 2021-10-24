package net.ibxnjadev.kruby.core.setup;

import java.io.File;

public class SetupDirectory implements SetupHandler {

    @Override
    public void setup() {
        createFolders("servers","templates","template-registry", "dockerfiles");
    }

    private void createFolders(String... folders) {
        for (String folder : folders) {
            createFolder(folder);
        }
    }

    private void createFolder(String folderName) {
        File folder = new File(folderName);
        folder.mkdirs();
    }

}
