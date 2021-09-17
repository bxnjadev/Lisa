package net.ibxnjadev.kruby.core.redis;

import net.ibxnjadev.kruby.core.storage.local.Storage;

public interface RedisCacheProvider {

    <V> Storage<V> findCache(Class<V> clazz);

}
