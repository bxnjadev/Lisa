package net.ibxnjadev.kruby.core.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.ibxnjadev.kruby.abstraction.redis.RedisCacheProvider;
import net.ibxnjadev.kruby.abstraction.util.Storage;
import net.ibxnjadev.kruby.abstraction.util.ClientProvider;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.Map;

public class CoreRedisCacheProvider implements RedisCacheProvider {

    private final Map<Class<?>, Storage<?>> maps = new HashMap<>();

    private final ObjectMapper mapper;
    private final ClientProvider<JedisPool> clientProvider;

    public CoreRedisCacheProvider(ObjectMapper mapper, ClientProvider<JedisPool> clientProvider) {
        this.mapper = mapper;
        this.clientProvider = clientProvider;
    }

    @Override
    public <V> Storage<V> findCache(Class<V> clazz) {

        if (!maps.containsKey(clazz)) {
            Storage<V> redisCache = new RedisCache<>(clazz, mapper, clientProvider);
            maps.put(clazz, redisCache);
            return redisCache;
        }

        return (Storage<V>) maps.get(clazz);
    }
}
