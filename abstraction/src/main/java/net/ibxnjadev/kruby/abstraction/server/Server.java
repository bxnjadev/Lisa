package net.ibxnjadev.kruby.abstraction.server;

import net.ibxnjadev.kruby.abstraction.model.Identifiable;

import java.util.function.Consumer;

/**
 * This class represents a minecraft server
 */

public interface Server extends Identifiable {

    /**
     * Get the container id the docker
     * @return the container id
     */

    String getContainerId();

    /**
     * Get the template name
     * @return the template name of server
     */

    String getTemplateName();

    /**
     * Get the id the template
     * @return the id the template of server
     */

    String getTemplateId();

    /**
     * restart the server
     */

    default void restart() {
        sendCommand("stop");
    }

    /**
     * Get the server name
     * @return the server name
     */

    String getName();

    /**
     * Get server type
     * @return the server type
     */

    ServerType getType();

    /**
     * Get the port server
     * @return the port server
     */

    int getPort();

    /**
     * Send a command to server
     * @param command the command
     */

    void sendCommand(String command);

    /**
     * Subscribe for read the console
     * @param consumer the consumer will be executed every time something new is received in the console
     */

    void subscribeConsole(Consumer<String> consumer) throws InterruptedException;

}
