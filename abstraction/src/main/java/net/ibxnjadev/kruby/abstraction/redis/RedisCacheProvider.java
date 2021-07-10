package net.ibxnjadev.kruby.abstraction.redis;

import net.ibxnjadev.kruby.abstraction.util.Storage;

public interface RedisCacheProvider {

    <V> Storage<String,V> findCache(Class<V> clazz);

}
