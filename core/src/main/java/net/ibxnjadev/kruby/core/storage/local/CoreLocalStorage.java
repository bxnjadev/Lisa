package net.ibxnjadev.kruby.core.storage.local;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.ibxnjadev.kruby.core.util.FileUtil;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class CoreLocalStorage<V> implements LocalStorage<V> {

    private static final String JSON_EXTENSION = ".json";

    private final ObjectMapper mapper;
    private final File directory;
    private final Class<V> clazz;

    public CoreLocalStorage(ObjectMapper mapper, File directory, Class<V> clazz) {
        this.mapper = mapper;
        this.directory = directory;
        this.clazz = clazz;
    }

    @Override
    public File getDirectory() {
        return directory;
    }

    @Override
    public void add(String key, V value) {
        try {
            FileUtil.createFileAndExecute(directory, key + ".json", (file -> {
                try {
                    mapper.writeValue(file, value);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<V> find(String key) {
        File file = new File(directory, key + JSON_EXTENSION);

        if (!file.exists()) {
            return Optional.empty();
        }

        try {
            return Optional.of(mapper.readValue(file, clazz));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void delete(String key) {
        if (exists(key)) {
            File fileDeleted = new File(directory, key + JSON_EXTENSION);
            fileDeleted.delete();
        }
    }

    @Override
    public boolean exists(String key) {
        return new File(directory, key + JSON_EXTENSION).exists();
    }

    @Override
    public Set<V> values() {
        Set<V> values = new HashSet<>();

        for (File file : directory.listFiles()) {
            find(FilenameUtils.removeExtension(file.getName())).ifPresent(values::add);
        }

        return values;
    }
}
