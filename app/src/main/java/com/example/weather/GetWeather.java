package com.example.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class GetWeather {
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather?lat=";
    private static final String IMG_URL = "http://openweathermap.org/img/w/";
    private final String apiKey;
    private double latitude;
    private double longitude;

    public GetWeather(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setCoords(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getWeatherData() {
        URL url;
        try {
            url = new URL(BASE_URL + latitude + "&lon=" + longitude + "&appid=" + apiKey);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        try (InputStream input = url.openStream()) {
            InputStreamReader isr = new InputStreamReader(input);
            BufferedReader reader = new BufferedReader(isr);
            StringBuilder json = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) ;
            {
                json.append((char) c);
            }
            return json.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}