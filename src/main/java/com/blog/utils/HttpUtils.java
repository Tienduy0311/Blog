package com.blog.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpUtils {

    public static <T> T toModel(String content, Class<T> model) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(content, model);
        } catch (JsonProcessingException e) {
            e.getMessage();
        }
        return null;
    }

    public static String of(BufferedReader reader) {
        try {
            String line;
            StringBuilder stringJson = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                stringJson.append(line);
            }
            return stringJson.toString();
        } catch (IOException e) {
            e.getMessage();
        }
        return null;
    }
}
