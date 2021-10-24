package net.ibxnjadev.kruby.core.messenger.message;

import java.beans.ConstructorProperties;

public class CreateServerMessage {

    private final String templateName;
    private final String serverName;
    private final String commandStart;
    private final boolean isStatic;
    private final int port;
    private final String[] variables;

    @ConstructorProperties(
            {
                    "template_name",
                    "server_name",
                    "command_start",
                    "is_static",
                    "port",
                    "variables"
            }
    )
    public CreateServerMessage(String templateName,
                               String serverName,
                               String commandStart,
                               boolean isStatic,
                               int port,
                               String[] variables) {
        this.templateName = templateName;
        this.serverName = serverName;
        this.commandStart = commandStart;
        this.isStatic = isStatic;
        this.port = port;
        this.variables = variables;
    }

    public String getTemplateName() {
        return templateName;
    }

    public String getServerName() {
        return serverName;
    }

    public String getCommandStart() {
        return commandStart;
    }

    public boolean isStatic() {
        return isStatic;
    }

    public int getPort() {
        return port;
    }

    public String[] getVariables() {
        return variables;
    }

}
