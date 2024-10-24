package com.test.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class JsonMapper {

    private final ObjectMapper objectMapper;

    public JsonMapper(final ObjectMapper objectMapper) {
        objectMapper.registerModule(new JavaTimeModule());

        this.objectMapper = objectMapper;
    }

    public <T> T fileAsObject(final String resourcePath, final Class<T> clazz) throws IOException {
        return objectMapper.readValue(new ClassPathResource(resourcePath).getFile(), clazz);
    }

    public <T> List<T> fileAsList(final String resourcePath, final Class<T> clazz) throws IOException {
        return objectMapper.readValue(new ClassPathResource(resourcePath).getFile(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));
    }

    public String objectToString(Object object) throws IOException {
        return objectMapper.writeValueAsString(object);
    }

}
