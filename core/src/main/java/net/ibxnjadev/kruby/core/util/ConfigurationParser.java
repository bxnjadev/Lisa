package net.ibxnjadev.kruby.core.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ConfigurationParser {

    private final ObjectMapper mapper;

    public ConfigurationParser(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public <T> T provideConfiguration(Class<T> clazz, File file) {
        try {
            return mapper.readValue(file, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
