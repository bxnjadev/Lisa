package net.ibxnjadev.kruby.core.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperProvider {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static ObjectMapper provideMapper() {
        return objectMapper;
    }

    public static void setObjectMapper(ObjectMapper mapper) {
        objectMapper = mapper;
    }

}
