package net.ibxnjadev.kruby.core.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.ibxnjadev.kruby.abstraction.model.Identifiable;
import net.ibxnjadev.kruby.abstraction.redis.RedisCacheProvider;
import net.ibxnjadev.kruby.abstraction.util.Cache;
import net.ibxnjadev.kruby.abstraction.util.ClientProvider;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.Map;

public class CoreRedisCacheProvider implements RedisCacheProvider {

    private final Map<Class<?>, Cache<?, ?>> maps = new HashMap<>();

    private final ObjectMapper mapper;
    private final ClientProvider<JedisPool> clientProvider;

    public CoreRedisCacheProvider(ObjectMapper mapper, ClientProvider<JedisPool> clientProvider) {
        this.mapper = mapper;
        this.clientProvider = clientProvider;
    }

    @Override
    public <K extends Identifiable, V> Cache<K, V> findCache(String cacheName, Class<V> clazz) {

        if (!maps.containsKey(clazz)) {
            maps.put(clazz, new RedisCache<>(cacheName, clazz, mapper, clientProvider.getClient()));
        }

        return null;
    }
}
