package com.example.weather;

import com.google.gson.Gson;

public class JsonWeather {
    public Coord coord;
    public Weather[] weather;
    public String base;
    public Main main;
    public int visibility;
    public Wind wind;
    public Clouds clouds;
    public long dt;
    public Sys sys;
    public int timezone;
    public int id;
    public String name;
    public int cod;

    public static JsonWeather fromJson(String JsonString) {
        JsonWeather weather = new JsonWeather();
        Gson gson = new Gson();
        weather = gson.fromJson(JsonString, JsonWeather.class);
        return weather;
    }
}
