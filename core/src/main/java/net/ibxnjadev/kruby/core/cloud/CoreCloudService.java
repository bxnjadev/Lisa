package net.ibxnjadev.kruby.core.cloud;

import com.github.dockerjava.api.DockerClient;
import net.ibxnjadev.kruby.core.server.Server;
import net.ibxnjadev.kruby.core.template.Template;
import net.ibxnjadev.kruby.core.server.CoreServer;
import net.ibxnjadev.kruby.helper.UtilId;
import net.ibxnjadev.kruby.helper.io.StreamHelper;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Consumer;

public class CoreCloudService implements CloudService {

    private static final String SEPARATOR = "_";

    private final Map<String, Server> servers = new HashMap<>();
    private final Map<String, String> serversIds = new HashMap<>();

    private final DockerCloudHandler dockerCloudHandler;
    private final CloudPortProvider cloudPortProvider;

    public CoreCloudService(DockerClient dockerClient, CloudPortProvider cloudPortProvider) {
        this.cloudPortProvider = cloudPortProvider;
        dockerCloudHandler = new DockerCloudHandler(dockerClient);
    }

    @Override
    public Server createServer(Template template, int port, String name, String commandStart, boolean isStatic, String[] variables) {

        String id = UtilId.randomId();

        if (port < 0) {
            port = cloudPortProvider.providePort();
        }

        if (name == null) {
            name = template.getName() + SEPARATOR + id;
        }

        String containerId = dockerCloudHandler
                .createContainer(template, port, name, commandStart, variables);

        Server server = new CoreServer(id,
                containerId,
                template.getName(),
                template.getId(),
                name,
                port,
                isStatic);

        loadServer(server);

        System.out.println("Server created: " + server.getId());
        return server;
    }

    @Override
    public void start(Server server) {
        dockerCloudHandler.startContainer(server);
    }

    @Override
    public void stop(Server server) {
        dockerCloudHandler.stopContainer(server);
    }

    @Override
    public void sendCommand(Server server, String command) {
        dockerCloudHandler.writeContainer(server, StreamHelper.transform(command));
    }

    @Override
    public void subscribe(Server server, Consumer<String> consumer) {
        try {
            dockerCloudHandler.attachContainer(server, consumer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadServer(Server server) {
        servers.put(server.getId(), server);
        serversIds.put(server.getName(), server.getId());
        start(server);
    }

    @Override
    public void deleteServer(Server server) {
        dockerCloudHandler.deleteAndStopContainer(server);
        servers.remove(server.getId());
    }

    @Override
    public Server getServer(String serverId) {
        return servers.get(serverId);
    }

    @Override
    public @Nullable Server getServerByName(String serverName) {
        return getServer(serversIds.get(serverName));
    }

    @Override
    public Set<Server> getAllServers() {
        return new HashSet<>(servers.values());
    }
}
