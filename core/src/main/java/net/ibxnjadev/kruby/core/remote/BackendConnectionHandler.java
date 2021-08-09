package net.ibxnjadev.kruby.core.remote;

import net.ibxnjadev.kruby.abstraction.cloud.CloudConfiguration;

/**
 *This class is in charge of managing requests with the remote backend
 */

public interface BackendConnectionHandler {

    /**
     * You send a connection request through redis
     * @param configuration The configuration of your machine
     */

    void sendConnection(CloudConfiguration configuration);

    /**
     * This method is executed when the backend responds to you
     * @param connected The answer of whether a connection to the backend could be made
     */

    void receiveReplyConnection(boolean connected);

}
