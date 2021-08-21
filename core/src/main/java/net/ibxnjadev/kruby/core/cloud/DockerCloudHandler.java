
package net.ibxnjadev.kruby.core.cloud;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.command.StartContainerCmd;
import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.HostConfig;
import com.github.dockerjava.api.model.Ports;
import net.ibxnjadev.kruby.core.server.Server;
import net.ibxnjadev.kruby.core.template.Template;
import net.ibxnjadev.kruby.core.util.ServerUtil;

public class DockerCloudHandler {

    private final DockerClient dockerClient;

    public DockerCloudHandler(DockerClient dockerClient) {
        this.dockerClient = dockerClient;
    }

    public String createContainer(Template template, int port, String serverName) {

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
                .withEnv("PORT=" + port, "COMMAND_START=" + ServerUtil.replaceCommandStart(template))
                .exec();
        return container.getId();
    }

    public void stopContainer(Server server) {
        dockerClient.stopContainerCmd(server.getContainerId())
                .exec();
    }

    public void deleteAndStopContainer(Server server) {
        stopContainer(server);
        dockerClient.removeContainerCmd(server.getContainerId()).exec();
    }

    private Ports createPorts(int port) {
        Ports portsBinding = new Ports();
        portsBinding.bind(ExposedPort.tcp(port), Ports.Binding.bindPort(port));
        return portsBinding;
    }

}
