
package net.ibxnjadev.kruby.core.cloud;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.HostConfig;
import com.github.dockerjava.api.model.Ports;
import com.github.dockerjava.core.command.AttachContainerResultCallback;
import net.ibxnjadev.kruby.core.attach.KrubyAttachContainer;
import net.ibxnjadev.kruby.core.server.Server;
import net.ibxnjadev.kruby.core.template.Template;
import net.ibxnjadev.kruby.helper.io.StreamHelper;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class DockerCloudHandler {

    private final DockerClient dockerClient;

    public DockerCloudHandler(DockerClient dockerClient) {
        this.dockerClient = dockerClient;
    }

    public String createContainer(Template template, int port, String serverName, String commandStart) {

        CreateContainerResponse container = dockerClient
                .createContainerCmd(template.getName())
                .withName(serverName)
                .withExposedPorts(ExposedPort.tcp(port))
                .withHostConfig(
                        new HostConfig()
                                .withPortBindings(createPorts(port))
                )
                .withTty(true)
                .withAttachStderr(true)
                .withAttachStdout(true)
                .withAttachStdin(true)
                .withEnv("PORT=" + port, "COMMAND_START=" + commandStart)
                .exec();
        return container.getId();
    }

    public void deleteAndStopContainer(Server server) {
        dockerClient.removeContainerCmd(server.getContainerId()).exec();
    }

    public void stopContainer(Server server) {
        dockerClient.stopContainerCmd(server.getContainerId()).exec();
    }

    public void startContainer(Server server) {
        dockerClient.startContainerCmd(server.getContainerId()).exec();
    }

    public void writeContainer(Server server, InputStream stream) {
        dockerClient.attachContainerCmd(server.getContainerId())
                .withStdIn(stream)
                .exec(new AttachContainerResultCallback());
    }

    public void attachContainer(Server server, Consumer<String> consumer) throws InterruptedException {
        dockerClient.attachContainerCmd(server.getContainerId())
                .withLogs(true)
                .withStdOut(true)
                .withFollowStream(true)
                .exec(new KrubyAttachContainer(consumer))
                .awaitCompletion(2L, TimeUnit.SECONDS);
    }

    private Ports createPorts(int port) {
        Ports portsBinding = new Ports();
        portsBinding.bind(ExposedPort.tcp(port), Ports.Binding.bindPort(port));
        return portsBinding;
    }

}
