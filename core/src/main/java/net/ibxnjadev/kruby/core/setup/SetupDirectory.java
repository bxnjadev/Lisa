package net.ibxnjadev.kruby.core.setup;

import java.io.File;

public class SetupDirectory implements SetupHandler {

    @Override
    public void setup() {

        createFolder("servers");
        createFolder("templates");
        createFolder("templates-registry");
        createFolder("dockerfiles");

    }

    private void createFolder(String folderName) {
        File folder = new File(folderName);
        folder.mkdirs();
    }

}
