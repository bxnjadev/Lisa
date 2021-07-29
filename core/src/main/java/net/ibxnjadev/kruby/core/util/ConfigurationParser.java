package net.ibxnjadev.kruby.core.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.ibxnjadev.kruby.core.mapper.ObjectMapperProvider;

import java.io.File;
import java.io.IOException;

public class ConfigurationParser {

    private final ObjectMapper mapper = ObjectMapperProvider.provideMapper();

    public <T> T provideConfiguration(Class<T> clazz, File file) {
        try {
            return mapper.readValue(file, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
