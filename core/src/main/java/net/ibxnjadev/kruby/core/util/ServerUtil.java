package net.ibxnjadev.kruby.core.util;

import net.ibxnjadev.kruby.core.template.Template;

public class ServerUtil {

    private final static String SERVER_JAR_VARIABLE
            = "java -jar {SERVER_JAR}";

    public static String replaceCommandStart(Template template) {
        return template.getCommandStart()
                .replace("{SERVER_JAR}", template.getPathJar());
    }

}
