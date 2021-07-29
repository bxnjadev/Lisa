package net.ibxnjadev.kruby.core.setup;

import net.ibxnjadev.kruby.abstraction.setup.SetupHandler;

import java.io.File;

public class SetupDirectory implements SetupHandler {

    @Override
    public void setup() {

        createFolder("servers");
        createFolder("templates");
        createFolder("dockerfiles");

    }

    private void createFolder(String folderName) {
        File folder = new File(folderName);
        folder.mkdirs();
    }

}
