package net.ibxnjadev.kruby.core.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperProvider {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static ObjectMapper provideMapper() {
        return OBJECT_MAPPER;
    }
}
