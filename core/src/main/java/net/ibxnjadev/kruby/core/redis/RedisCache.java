package net.ibxnjadev.kruby.core.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.ibxnjadev.kruby.core.util.Storage;
import net.ibxnjadev.kruby.core.util.ClientProvider;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class RedisCache<V> implements Storage<V> {

    private final Class<V> clazz;
    private final ObjectMapper mapper;
    private final String className;
    private final JedisPool jedisPool;

    public RedisCache(Class<V> clazz, ObjectMapper mapper, ClientProvider<JedisPool> clientProvider) {
        this.clazz = clazz;
        this.mapper = mapper;
        className = (String) clazz.getName().toLowerCase();
        jedisPool = clientProvider.getClient();
    }

    @Override
    public void add(String key, V value) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.set(className + ":" + key, mapper.writeValueAsString(value));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<V> find(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            try {
                return Optional.ofNullable(mapper.readValue(jedis.get(className + ":" + key), clazz));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return Optional.empty();
    }

    @Override
    public void delete(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.del(className + ":" + key);
        }
    }

    @Override
    public boolean exists(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.exists(className + ":" + key);
        }
    }

    @Override
    public Set<V> values() {

        Set<V> values = new HashSet<>();

        try (Jedis jedis = jedisPool.getResource()) {
            jedis.keys(className + ":*")
                    .forEach(key -> {
                        try {
                            values
                                    .add(mapper.readValue(jedis.get(className + ":" + key), clazz));
                        } catch (JsonProcessingException e) {
                            e.printStackTrace();
                        }
                    });
        }

        return values;
    }
}
