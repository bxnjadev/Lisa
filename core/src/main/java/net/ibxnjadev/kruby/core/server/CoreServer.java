package net.ibxnjadev.kruby.core.server;

import com.github.dockerjava.api.DockerClient;
import net.ibxnjadev.kruby.core.attach.KrubyAttachContainer;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class CoreServer implements Server {

    private final String id;
    private final String containerId;
    private final String templateName;
    private final String templateId;
    private final String name;
    private final ServerType serverType;
    private final int port;
    private final boolean isStatic;

    private final DockerClient client;

    public CoreServer(String id,
                      String containerId,
                      String templateName,
                      String templateId,
                      String name,
                      ServerType serverType,
                      int port,
                      boolean isStatic,
                      DockerClient client) {
        this.id = id;
        this.containerId = containerId;
        this.templateName = templateName;
        this.templateId = templateId;
        this.name = name;
        this.serverType = serverType;
        this.port = port;
        this.isStatic = isStatic;
        this.client = client;
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
    public ServerType getType() {
        return serverType;
    }

    @Override
    public int getPort() {
        return port;
    }

    @Override
    public void sendCommand(String command) {
    }

    @Override
    public void subscribeConsole(Consumer<String> consumer) throws InterruptedException {
        client.attachContainerCmd(containerId)
                .withLogs(true)
                .withStdOut(true)
                .withFollowStream(true)
                .exec(new KrubyAttachContainer(consumer))
                .awaitCompletion(2L, TimeUnit.SECONDS);
    }

    @Override
    public void start() {
        client.startContainerCmd(containerId).exec();
    }

    @Override
    public void stop() {
        client.stopContainerCmd(containerId).exec();
    }

}
