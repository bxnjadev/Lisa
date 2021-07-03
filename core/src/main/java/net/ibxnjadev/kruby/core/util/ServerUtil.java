package net.ibxnjadev.kruby.core.util;

import net.ibxnjadev.kruby.abstraction.template.Template;

public class ServerUtil {

    private final static String SERVER_JAR_VARIABLE
            = "{SERVER_JAR}";

    public static String replaceCommandStart(Template template) {
        return template.getCommandStart()
                .replace(SERVER_JAR_VARIABLE, template.getPathJar());
    }

}
