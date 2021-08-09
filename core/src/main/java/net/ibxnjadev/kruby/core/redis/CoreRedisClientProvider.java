package net.ibxnjadev.kruby.core.redis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class CoreRedisClientProvider implements RedisClientProvider {

    private final RedisConfiguration configuration;
    private JedisPool jedisPool;
    public CoreRedisClientProvider(RedisConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void establishConnection() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(8);

        JedisPool jedisPool;

        if (configuration.getPassword() != null && !configuration.getPassword().trim().isEmpty()) {
            jedisPool = new JedisPool(jedisPoolConfig, configuration.getHost(), configuration.getPort(), 2000, configuration.getPassword());
        } else {
            jedisPool = new JedisPool(jedisPoolConfig, configuration.getHost(), configuration.getPort(), 2000);
        }

        this.jedisPool = jedisPool;
    }

    @Override
    public JedisPool getClient() {
        return jedisPool;
    }
}
