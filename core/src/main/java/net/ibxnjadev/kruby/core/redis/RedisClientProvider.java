package net.ibxnjadev.kruby.core.redis;

import net.ibxnjadev.kruby.core.util.ClientProvider;
import redis.clients.jedis.JedisPool;

/**
 * This class create the connection with redis
 */

public interface RedisClientProvider extends ClientProvider<JedisPool> {

    /**
     * Create the connection
     */

    void establishConnection();

}
