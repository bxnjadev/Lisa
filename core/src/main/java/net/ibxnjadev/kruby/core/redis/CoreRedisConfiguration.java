package net.ibxnjadev.kruby.core.redis;

import java.beans.ConstructorProperties;

public class CoreRedisConfiguration implements RedisConfiguration {

    private final String host;
    private final int port;
    private final String password;

    @ConstructorProperties({"host", "port", "password"})
    public CoreRedisConfiguration(String host, int port, String password) {
        this.host = host;
        this.port = port;
        this.password = password;
    }

    @Override
    public String getHost() {
        return host;
    }

    @Override
    public int getPort() {
        return port;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
