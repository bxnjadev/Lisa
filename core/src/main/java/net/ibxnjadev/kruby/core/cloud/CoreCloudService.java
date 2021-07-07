package net.ibxnjadev.kruby.core.cloud;

import com.github.dockerjava.api.DockerClient;
import net.ibxnjadev.kruby.abstraction.cloud.CloudPortProvider;
import net.ibxnjadev.kruby.abstraction.cloud.CloudService;
import net.ibxnjadev.kruby.abstraction.server.Server;
import net.ibxnjadev.kruby.abstraction.template.Template;

import java.util.*;

public class CoreCloudService implements CloudService {

    private final Map<String, Server> servers = new HashMap<>();
    private final DockerCloudHandler dockerCloudHandler;
    private final DockerClient dockerClient;
    private final CloudPortProvider cloudPortProvider;

    public CoreCloudService(DockerClient dockerClient, CloudPortProvider cloudPortProvider) {
        this.dockerClient = dockerClient;
        this.cloudPortProvider = cloudPortProvider;
        dockerCloudHandler = new DockerCloudHandler(dockerClient);
    }

    @Override
    public Server createServer(Template template, int port) {



        return null;
    }

    @Override
    public void deleteServer(String serverId) {
        findServer(serverId).ifPresent(server -> {
            dockerCloudHandler.deleteAndStopContainer(server);
            servers.remove(serverId);
        });
    }

    @Override
    public Optional<Server> findServer(String serverId) {
        return Optional.ofNullable(servers.get(serverId));
    }

    @Override
    public Set<Server> getAllServers() {
        return new HashSet<>(servers.values());
    }
}
