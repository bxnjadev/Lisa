package net.ibxnjadev.kruby.core.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.ibxnjadev.kruby.abstraction.util.Cache;
import net.ibxnjadev.kruby.abstraction.util.ClientProvider;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class RedisCache<String, V> implements Cache<String, V> {

    private final Class<V> clazz;
    private final ObjectMapper mapper;
    private final String cacheName;
    private final JedisPool jedisPool;

    public RedisCache(String cacheName, Class<V> clazz, ObjectMapper mapper, ClientProvider<JedisPool> clientProvider) {
        this.cacheName = cacheName;
        this.clazz = clazz;
        this.mapper = mapper;
        jedisPool = clientProvider.getClient();
    }

    @Override
    public void add(String key, V value) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.set(cacheName + ":" + key, mapper.writeValueAsString(value));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<V> find(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            try {
                return Optional.ofNullable(mapper.readValue(jedis.get(cacheName + ":" + key), clazz));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return Optional.empty();
    }

    @Override
    public void delete(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.del(cacheName + ":" + key);
        }
    }

    @Override
    public boolean exists(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.exists(cacheName + ":" + key);
        }
    }

    @Override
    public Set<V> values() {

        Set<V> values = new HashSet<>();

        try (Jedis jedis = jedisPool.getResource()) {
            jedis.keys(cacheName + ":*")
                    .forEach(key -> {
                        try {
                            values
                                    .add(mapper.readValue(jedis.get(cacheName + ":" + key), clazz));
                        } catch (JsonProcessingException e) {
                            e.printStackTrace();
                        }
                    });
        }

        return values;
    }
}
