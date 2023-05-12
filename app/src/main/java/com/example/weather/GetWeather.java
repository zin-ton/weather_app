package com.example.weather;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class GetWeather {
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather?lat=";
    private static final String IMG_URL = "http://openweathermap.org/img/w/";
    private String apiKey;
    private double latitude;
    private double longitude;
    public GetWeather(String apiKey) {
        this.apiKey = apiKey;
    }
    public void setCoords(double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getWeatherData(String location) {
        try {
            URL url = new URL(BASE_URL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
