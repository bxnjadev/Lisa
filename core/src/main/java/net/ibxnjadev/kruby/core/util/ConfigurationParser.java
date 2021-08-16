package net.ibxnjadev.kruby.core.util;

import net.ibxnjadev.kruby.core.mapper.ObjectMapperProvider;

import java.io.File;
import java.io.IOException;

public class ConfigurationParser {

    public static <T> T provideConfiguration(Class<T> clazz, File file) {
        try {
            return ObjectMapperProvider.defaultMapper().readValue(file, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
