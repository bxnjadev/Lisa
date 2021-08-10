package net.ibxnjadev.kruby.core.storage.local;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.ibxnjadev.kruby.core.mapper.ObjectMapperProvider;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class LocalStorageProvider {

    private static final Map<Class<?>, LocalStorage<?>> LOCAL_STORAGE_CACHE = new HashMap<>();
    private static final ObjectMapper MAPPER = ObjectMapperProvider.provideMapper();

    public static <V> LocalStorage<V> findStorage(Class<V> clazz) {
        return (LocalStorage<V>) LOCAL_STORAGE_CACHE.get(clazz);
    }

    public static <V> LocalStorage<V> registerStorage(Class<V> clazz, File directory, ObjectMapper externalMapper) {
        LocalStorage<V> localStorage = new CoreLocalStorage<>(externalMapper == null ? MAPPER : externalMapper, directory, clazz);
        LOCAL_STORAGE_CACHE.put(clazz,localStorage);

        return localStorage;
    }

    public static <V> LocalStorage<V> registerStorage(Class<V> clazz, File directory) {
        return registerStorage(clazz, directory, null);
    }

}
