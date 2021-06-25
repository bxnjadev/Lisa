package net.ibxnjadev.kruby.abstraction.redis;

import net.ibxnjadev.kruby.abstraction.util.Cache;

public interface RedisCacheProvider {

    <V> Cache<String,V> findCache(Class<V> clazz);

}
