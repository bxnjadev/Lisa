package net.ibxnjadev.kruby.core.util;

import java.util.Optional;
import java.util.Set;

/**
 * This class represent the cache
 * @param <V> the object
 */

public interface Storage<V> {

    /**
     * Insert object in cache
     */

    void add(String key, V value);

    /**
     * Find user by id
     */

    Optional<V> find(String key);

    /**
     * Delete user by id
     */

    void delete(String key);

    /**
     * Verify if user exists
     */

    boolean exists(String key);

    /**
     * Get all content in object cache
     * @return a set the content in object cache
     */

    Set<V> values();

}
