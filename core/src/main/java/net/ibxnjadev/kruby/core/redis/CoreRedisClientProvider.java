package net.ibxnjadev.kruby.core.redis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;

public class CoreRedisClientProvider implements RedisClientProvider {

    private final RedisConfiguration configuration;
    private JedisPool jedisPool;
    public CoreRedisClientProvider(RedisConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void establishConnection() {

        try {
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(8);

            JedisPool jedisPool;

            System.out.println("host " + configuration.getHost());
            System.out.println("port " + configuration.getPort());
            System.out.println("password " + configuration.getPassword());

            if (configuration.getPassword() != null && !configuration.getPassword().trim().isEmpty()) {
                jedisPool = new JedisPool(jedisPoolConfig, configuration.getHost(), configuration.getPort(), 2000, configuration.getPassword());
            } else {
                jedisPool = new JedisPool(jedisPoolConfig, configuration.getHost(), configuration.getPort(), 2000);
            }

            this.jedisPool = jedisPool;
        } catch (JedisConnectionException e) {
            System.out.println("Error: in redis connection");
        }

    }

    @Override
    public JedisPool getClient() {
        return jedisPool;
    }
}
