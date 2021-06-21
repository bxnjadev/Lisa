package net.ibxnjadev.kruby.abstraction.redis;

/**
 * This class contain redis configuration for create a connection
 */

public interface RedisConfiguration {

    /**
     * @return The host
     */

    String getHost();

    /**
     * @return The port
     */

    int getPort();

    /**
     * @return The password
     */

    String getPassword();

}
