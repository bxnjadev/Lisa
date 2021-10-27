package net.ibxnjadev.kruby.core.template;

import net.ibxnjadev.kruby.helper.io.StreamHelper;

import java.io.*;

public class TemplateUtil {

    public static void setupTemplateEnvironment(Template template, String dockerfileNameDirectory) {

        File directory = new File("dockerfiles/" + dockerfileNameDirectory + "/");

        System.out.println(directory);

        File dockerfile = new File(directory, "Dockerfile");
        File entrypoint = new File(directory, "entrypoint.sh");

        File directoryTemplate = template.getDirectory();
        System.out.println(directoryTemplate);

        File dockerfileTemplate = new File(directoryTemplate, "Dockerfile");
        File entrypointTemplate = new File(directoryTemplate, "entrypoint.sh");

        try {

            dockerfileTemplate.createNewFile();
            entrypointTemplate.createNewFile();

            InputStream dockerInput = new FileInputStream(dockerfile);
            InputStream entrypointInput = new FileInputStream(entrypoint);

            OutputStream dockerOutputStream = new FileOutputStream(dockerfileTemplate);
            OutputStream entrypointOutputStream = new FileOutputStream(entrypointTemplate);

            StreamHelper.copyStream(dockerInput, dockerOutputStream);
            StreamHelper.copyStream(entrypointInput, entrypointOutputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
