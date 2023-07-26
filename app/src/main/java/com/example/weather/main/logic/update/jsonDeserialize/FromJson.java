package com.example.weather.main.logic.update.jsonDeserialize;

import com.example.weather.main.logic.update.jsonFiles.WeatherJson;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FromJson {
    public static WeatherJson fromJson(String answer){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(answer, WeatherJson.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
