package net.ibxnjadev.kruby.core.cloud;

import net.ibxnjadev.kruby.core.server.Server;
import net.ibxnjadev.kruby.core.template.Template;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class manages all functions of the cloud
 */

public interface CloudService {

    /**
     * Create a minecraft server based on a template
     * @param template the template that will be used to create the server
     * @param port the server port, if you don't specify the port you will be chosen a random one
     * @return The created server
     */

    Server createServer(Template template, int port, String name);

    /**
     * Create a minecraft server based on a template
     * @param template the template that will be used to create the server
     * @return The created server
     */

    default Server createServer(Template template, String name) {
        return createServer(template, -1, name);
    }

    /**
     * Delete a server
     * @param serverId The id of the server you want to delete
     */

    void deleteServer(String serverId);

    /**
     * Find a server
     * @param serverId The id of the server you want to delete
     * @return The server you searched for
     */

    Optional<Server> findServer(String serverId);

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
