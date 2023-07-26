package com.example.weather.main.logic.update;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WeatherUpdater {
    static String url = "/updateWeather/";//TODO: ADD IP;

    public static String updateWeather(String id, Double longitude, Double latitude){
        String answer = null;
        url += id + "/" + longitude + "/" + latitude;
        try{
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
            httpURLConnection.setRequestMethod("GET");
            InputStream is = httpURLConnection.getInputStream();
            httpURLConnection.connect();
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            answer = new String(buffer);
            httpURLConnection.disconnect();
            return answer;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return answer;
    }
}
