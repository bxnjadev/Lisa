package net.ibxnjadev.kruby.core.remote;

import net.ibxnjadev.kruby.core.cloud.CloudConfiguration;
import net.ibxnjadev.kruby.core.remote.message.BackendAuthorizationResponseMessage;

/**
 *This class is in charge of managing requests with the remote backend
 */

public interface BackendConnectionHandler {

    /**
     * You send a connection request through redis
     * @param configuration The configuration of your machine
     */

    void connect(CloudConfiguration configuration);

    /**
     * Reconnect the connection with the backend
     * @param configuration The configuration of your machine
     */

    void reconnect(CloudConfiguration configuration);

    /**
     * This method is executed when the backend responds to you
     * @param
     */

    void receiveAuthorizationResponse(BackendAuthorizationResponseMessage response);

}
