package net.ibxnjadev.kruby.core.storage.local;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.ibxnjadev.kruby.helper.mapper.ObjectMapperProvider;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class LocalStorageProvider {

    private final Map<Class<?>, LocalStorage<?>> Storage = new HashMap<>();
    private final ObjectMapper mapper;

    public LocalStorageProvider(ObjectMapperProvider objectMapperProvider) {
        this.mapper = objectMapperProvider.getMapper();
    }

    public <V> LocalStorage<V> findStorage(Class<V> clazz) {
        return (LocalStorage<V>) Storage.get(clazz);
    }

    public <V> LocalStorage<V> registerStorage(Class<V> clazz, File directory, ObjectMapper externalMapper) {
        LocalStorage<V> localStorage = new CoreLocalStorage<>(externalMapper == null ? mapper : externalMapper, directory, clazz);
        Storage.put(clazz, localStorage);

        return localStorage;
    }

    public <V> LocalStorage<V> registerStorage(Class<V> clazz, File directory) {
        return registerStorage(clazz, directory, null);
    }

}
