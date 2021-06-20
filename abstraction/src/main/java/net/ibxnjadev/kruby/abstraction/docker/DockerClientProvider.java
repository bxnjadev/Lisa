package net.ibxnjadev.kruby.abstraction.docker;

import com.github.dockerjava.api.DockerClient;

/**
 * This class provides you with a docker client
 */

public interface DockerClientProvider {

    /**
     * Establishes a connection with the docker that is on the machine running the cloud
     */

    void establishConnection();

    /**
     * @return get the docker client
     */

    DockerClient getClient();

}
