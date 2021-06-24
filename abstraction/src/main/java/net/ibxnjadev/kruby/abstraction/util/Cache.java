package net.ibxnjadev.kruby.abstraction.util;

import net.ibxnjadev.kruby.abstraction.model.Identifiable;

import java.util.Optional;
import java.util.Set;

/**
 * This class represent the cache
 * @param <K> the key for objects
 * @param <V> the object
 */

public interface Cache<K extends Identifiable, V> {

    /**
     * Insert object in cache
     */

    void add(K key, V value);

    /**
     * Find user by id
     */

    Optional<V> find(K key);

    /**
     * Delete user by id
     */

    void delete(K key);

    /**
     * Verify if user exists
     */

    boolean exists(K key);

    /**
     * Get all content in object cache
     * @return a set the content in object cache
     */

    Set<V> values();

}
