package net.ibxnjadev.kruby.core.cloud;

import com.github.dockerjava.api.DockerClient;
import net.ibxnjadev.kruby.core.server.Server;
import net.ibxnjadev.kruby.core.template.Template;
import net.ibxnjadev.kruby.core.server.CoreServer;
import net.ibxnjadev.kruby.core.util.UtilId;

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
    public Server createServer(Template template, int port, String name) {

        String id = UtilId.randomId();

        if (port == -1) {
            port = cloudPortProvider.providePort();
        }

        if (name == null) {
            name = template.getName() + "_" + id;
        }

        String containerId = dockerCloudHandler
                .createContainer(template, port, name);

        Server server = new CoreServer(id, containerId, template.getName(), template.getId(), name, template.getType(), port, dockerClient);
        servers.put(id, server);

        System.out.println("Server created: " + server.getId());
        return server;
    }

    @Override
    public void loadServer(Server server) {
        servers.put(server.getId(), server);
        server.start();
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
