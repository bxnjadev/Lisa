package net.ibxnjadev.kruby.abstraction.cloud;

/**
 * this class provides you with the configuration used to make a connection to a backend
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

    boolean isEnabled();

    /**
     * Obtain the key that you have configured, it will be used to make a connection to the cloud
     * @return the key you have configured
     */

    String getKey();

}
