package net.ibxnjadev.kruby.helper.storage;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.ibxnjadev.kruby.helper.mapper.ObjectMapperProvider;

import java.io.File;
import java.io.IOException;

public class ConfigurationParser {

    private ConfigurationParser() {
    }

    public static <T> T parse(Class<T> clazz, File file) {
        return parse(clazz, file, null);
    }

    public static <T> T parse(Class<T> clazz, File file, ObjectMapper mapper) {
        try {
            return mapper == null ? ObjectMapperProvider.defaultMapper().readValue(file, clazz) : mapper.readValue(file, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
