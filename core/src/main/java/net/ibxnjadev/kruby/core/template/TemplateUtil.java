package net.ibxnjadev.kruby.core.template;

import net.ibxnjadev.kruby.abstraction.template.Template;

import java.io.*;

public class TemplateUtil {

    public static void setupTemplateEnvironment(Template template, String dockerfileNameDirectory) {

        File directory = new File("/dockerfiles/ " + dockerfileNameDirectory);
        File dockerfile = new File(directory, "dockerfile");
        File entrypoint = new File(directory, "entrypoint.sh");

        File directoryTemplate = template.getDirectory();
        File dockerfileTemplate = new File(directoryTemplate, "dockerfile");
        File entrypointTemplate = new File(directoryTemplate, "entrypoint.sh");

        try {

            dockerfileTemplate.createNewFile();
            entrypointTemplate.createNewFile();

            InputStream dockerInput = new FileInputStream(dockerfile);
            InputStream entrypointInput = new FileInputStream(entrypoint);

            OutputStream dockerOutputStream = new FileOutputStream(dockerfileTemplate);
            OutputStream entrypointOutputStream = new FileOutputStream(entrypointTemplate);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
