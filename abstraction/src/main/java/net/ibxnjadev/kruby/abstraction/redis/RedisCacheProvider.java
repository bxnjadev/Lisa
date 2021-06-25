package net.ibxnjadev.kruby.abstraction.redis;

import net.ibxnjadev.kruby.abstraction.model.Identifiable;
import net.ibxnjadev.kruby.abstraction.util.Cache;

public interface RedisCacheProvider {

    <K extends Identifiable,V> Cache<K,V> findCache(String cacheName, Class<V> clazz);

}
