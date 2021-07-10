package net.ibxnjadev.kruby.core.storage.local;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.ibxnjadev.kruby.abstraction.storage.local.LocalStorage;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class LocalStorageProvider {

    private static final Map<Class<?>, LocalStorage<String, ?>> LOCAL_STORAGE_CACHE = new HashMap<>();
    private static final ObjectMapper mapper = new ObjectMapper();

    public static <V> LocalStorage<String, V> findStorage(Class<V> clazz) {
        if (!LOCAL_STORAGE_CACHE.containsKey(clazz)) {
            return null;
        }
        return (LocalStorage<String, V>) LOCAL_STORAGE_CACHE.get(clazz);
    }

    public static <V> LocalStorage<String, V> registerStorage(Class<V> clazz, File directory, ObjectMapper externalMapper) {
        LocalStorage<String,V> localStorage = new CoreLocalStorage<>(externalMapper == null ? mapper : externalMapper, directory, clazz);
        LOCAL_STORAGE_CACHE.put(clazz,localStorage);

        return localStorage;
    }

    public static <V> LocalStorage<String, V> registerStorage(Class<V> clazz, File directory) {
        return registerStorage(clazz, directory, null);
    }

}