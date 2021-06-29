package net.ibxnjadev.kruby.core.cloud;

import com.github.dockerjava.api.DockerClient;
import net.ibxnjadev.kruby.abstraction.cloud.CloudService;
import net.ibxnjadev.kruby.abstraction.server.Server;
import net.ibxnjadev.kruby.abstraction.template.Template;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class CoreCloudService implements CloudService {

    private final Map<String, Server> servers = new HashMap<>();
    private final DockerCloudHandler dockerCloudHandler;

    private final DockerClient dockerClient;

    public CoreCloudService(DockerClient dockerClient) {
        this.dockerClient = dockerClient;
        dockerCloudHandler = new DockerCloudHandler(dockerClient);
    }

    @Override
    public Server createServer(Template template, int port) {



        return null;
    }

    @Override
    public void deleteServer(String serverId) {

    }

    @Override
    public Optional<Server> findServer(String serverId) {
        return Optional.empty();
    }

    @Override
    public Set<Server> getAllServers() {
        return null;
    }
}
