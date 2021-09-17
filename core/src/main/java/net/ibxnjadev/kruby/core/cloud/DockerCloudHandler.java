
package net.ibxnjadev.kruby.core.cloud;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.HostConfig;
import com.github.dockerjava.api.model.Ports;
import net.ibxnjadev.kruby.core.server.Server;
import net.ibxnjadev.kruby.core.template.Template;

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
        server.stop();
        dockerClient.removeContainerCmd(server.getContainerId()).exec();
    }

    private Ports createPorts(int port) {
        Ports portsBinding = new Ports();
        portsBinding.bind(ExposedPort.tcp(port), Ports.Binding.bindPort(port));
        return portsBinding;
    }

}
