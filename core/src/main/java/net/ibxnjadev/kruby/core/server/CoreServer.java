package net.ibxnjadev.kruby.core.server;

import java.beans.ConstructorProperties;

public class CoreServer implements Server {

    private final String id;
    private final String containerId;
    private final String templateName;
    private final String templateId;
    private final String name;
    private final int port;
    private final boolean isStatic;

    @ConstructorProperties({
            "id",
            "containerId",
            "templateName",
            "templateId",
            "name",
            "port",
            "isStatic"
    })
    public CoreServer(String id,
                      String containerId,
                      String templateName,
                      String templateId,
                      String name,
                      int port,
                      boolean isStatic) {
        this.id = id;
        this.containerId = containerId;
        this.templateName = templateName;
        this.templateId = templateId;
        this.name = name;
        this.port = port;
        this.isStatic = isStatic;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getContainerId() {
        return containerId;
    }

    @Override
    public String getTemplateName() {
        return templateName;
    }

    @Override
    public String getTemplateId() {
        return templateId;
    }

    @Override
    public boolean isStatic() {
        return isStatic;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPort() {
        return port;
    }

}
