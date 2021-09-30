package net.ibxnjadev.kruby.helper.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperProvider {

    private static final ObjectMapper DEFAULT_OBJECT_MAPPER = new ObjectMapper();

    private final ObjectMapper objectMapper;

    public ObjectMapperProvider(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ObjectMapper getMapper() {
        return objectMapper;
    }

    public static ObjectMapper defaultMapper() {
        return DEFAULT_OBJECT_MAPPER;
    }

}
