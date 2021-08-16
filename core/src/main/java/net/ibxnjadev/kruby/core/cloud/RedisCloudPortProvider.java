package net.ibxnjadev.kruby.core.cloud;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisCloudPortProvider implements CloudPortProvider {

    private final JedisPool jedisPool;
    private final String ip;

    public RedisCloudPortProvider(JedisPool jedisPool, String ip) {
        this.jedisPool = jedisPool;
        this.ip = ip;
    }

    @Override
    public int providePort() {

        int randomPort = randomPort();

        try (Jedis jedis = jedisPool.getResource()) {
            if (jedis.exists(ip + ":" + randomPort)) {
                return providePort();
            }
        }

        return randomPort;
    }

    @Override
    public void assignPort(int port) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.set(ip + ":" + randomPort(), "true");
        }
    }
}
