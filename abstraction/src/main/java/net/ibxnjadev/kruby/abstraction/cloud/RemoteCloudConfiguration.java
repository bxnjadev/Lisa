package net.ibxnjadev.kruby.abstraction.cloud;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Check if a remote connection can be made to a backend
 * @return if a remote connection can be made to a backend
 */

public interface RemoteCloudConfiguration {

    /**
     * Method used to establish that a connection is made to the backend
     */

    void establishConnected();

    /**
     * Check if a connection was made with the backend
     * @return if a connection was made with the backend
     */

    boolean isConnected();

    /**
     * Check if a remote connection can be made to a backend
     * @return if a remote connection can be made to a backend
     */

    @JsonIgnore
    boolean isEnabled();

    /**
     * Obtain the key that you have configured, it will be used to make a connection to the cloud
     * @return the key you have configured
     */

    String getKey();

}
