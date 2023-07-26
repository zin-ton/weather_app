package com.example.weather.main.logic.update.jsonFiles;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherJson {
    private Coordinates coord;
    private Weather[] weather;
    private Main main;
    private Wind wind;
    private long dt;
    private Sys sys;
    private String name;
    private Long cod;
    private double visibility;
    private Clouds clouds;
    private Long timezone;
    private String base;
    private Long id;

    public Long getCod() {
        return cod;
    }

    public void setCod(Long cod) {
        this.cod = cod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Long getTimezone() {
        return timezone;
    }

    public void setTimezone(Long timezone) {
        this.timezone = timezone;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Coordinates getCoord() {
        return coord;
    }

    public void setCoord(Coordinates coord) {
        this.coord = coord;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getVisibility() {
        return visibility;
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }
}
