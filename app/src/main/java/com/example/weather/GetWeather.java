package com.example.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class GetWeather {
    private static final String BASE_URL = "http://87.246.197.119:8080/proxy?lon=";
    private static final String IMG_URL = "http://openweathermap.org/img/w/";
    private double latitude;
    private double longitude;


    public void setCoords(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getWeatherData() {
        URL url;
        try {
            url = new URL(BASE_URL + longitude + "&lat=" + latitude);
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
