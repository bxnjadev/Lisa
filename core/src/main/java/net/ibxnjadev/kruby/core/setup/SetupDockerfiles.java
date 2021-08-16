package net.ibxnjadev.kruby.core.setup;

import net.ibxnjadev.kruby.core.util.StreamHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class SetupDockerfiles implements SetupHandler {

    private static final File DIRECTORY = new File("dockerfiles");
    private static final String[] DOCKER_FILES = {"java_8", "java_9", "java_11", "java_16"};

    @Override
    public void setup() {
            try {

                for (String dockerFile : DOCKER_FILES) {
                copyDirectory(dockerFile);
                }

            } catch (IOException e) {
                e.printStackTrace();
        }
    }

    public void copyDirectory(String dockerfileName) throws IOException {

        File dockerfileDirectory = new File(DIRECTORY, dockerfileName);
        dockerfileDirectory.mkdirs();

        InputStream inputStreamDockerfile =
                StreamHelper.getResource("dockerfiles/" + dockerfileName + "/Dockerfile");

        InputStream inputStreamEntrypoint =
                StreamHelper.getResource("dockerfiles/" + dockerfileName + "/entrypoint.sh");

        File fileDockerfile
                = new File(dockerfileDirectory, "Dockerfile");

        File fileEntrypoint
                = new File(dockerfileDirectory, "entrypoint.sh");

        fileDockerfile.createNewFile();
        fileEntrypoint.createNewFile();

        StreamHelper
                .copyStream(inputStreamDockerfile, new FileOutputStream(fileDockerfile));

        StreamHelper
                .copyStream(inputStreamEntrypoint, new FileOutputStream(fileEntrypoint));

    }

}
