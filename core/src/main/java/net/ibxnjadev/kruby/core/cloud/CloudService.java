package net.ibxnjadev.kruby.core.cloud;

import net.ibxnjadev.kruby.core.server.Server;
import net.ibxnjadev.kruby.core.template.Template;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * This class manages all functions of the cloud
 */

public interface CloudService {

    /**
     * Create a minecraft server based on a template
     * @param template the template that will be used to create the server
     * @param port the server port, if you don't specify the port you will be chosen a random one
     * @param name the server name
     * @param commandStart the command for run the server
     * @param isStatic if the server is static or permanent
     * @param variables the variables for create server
     * @return The created server
     */

    Server createServer(Template template, int port, String name, String commandStart, boolean isStatic, String[] variables) throws ExecutionException, InterruptedException;

    /**
     * Create a minecraft server based on a template
     * @param template the template that will be used to create the server
     * @param name the server name
     * @param commandStart the command for run the server
     * @param isStatic if the server is static or permanent
     * @return The created server
     */

    default Server createServer(Template template, String name, String commandStart, boolean isStatic, String[] variables) {
        return createServer(template, -1, name, commandStart, isStatic, variables);
    }

    /**
     * Start a server
     * @param server the server
     */

    void start(Server server);

    /**
     * Stop a server
     * @param server the server
     */

    void stop(Server server);

    /**
     * Send a command to server
     * @param command the command
     */

    void sendCommand(Server server, String command);

    /**
     * Subscribe for read the console
     * @param consumer the consumer will be executed every time something new is received in the console
     */

    void subscribe(Server server, Consumer<String> consumer);

    /**
     * Load the server in cache and run
     * @param server the server
     */

    void loadServer(Server server);

    /**
     * Delete a server
     * @param server the server
     */

    void deleteServer(Server server);

    /**
     * Find a server
     * @param serverId The id of the server you want to delete
     * @return The server you searched for
     */

    @Nullable
    Server getServer(String serverId);

    /**
     * Find a server
     * @param serverName the name Server
     * @return The server you searched for
     */

    @Nullable
    Server getServerByName(String serverName);

    /**
     * Get all servers
     * @return all servers
     */

    Set<Server> getAllServers();

    /**
     * get all the servers that belong to a template
     * @param templateName The name of the template to search
     * @return all servers that belong to the template
     */

    default Set<Server> getAllServerInTemplate(String templateName) {
        return getAllServers()
                .stream()
                .filter(server -> server.getTemplateName().equals(templateName))
                .collect(Collectors.toSet());
    }

}
