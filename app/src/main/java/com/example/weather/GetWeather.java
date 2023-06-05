package com.example.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

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
            url = new URL(BASE_URL + latitude + "&lon=" + longitude + "&appid=" + apiKey + "&units=metric");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        try {
            StringBuilder result = new StringBuilder();
            URLConnection conn = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
            return result.toString();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
