package com.example.weather.main.logic.gps;
//TODO WORKING DONT TOUCH!!!!!!!!!!!!!!!
import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class GpsManager implements LocationListener {
    private LocationManager locationManager;
    private LocationListener locationListener;
    private double longitude;
    private double latitude;
    public GpsManager(Context context){
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        locationListener = this;
    }
    public void startLocationUpdates(Activity context){
        if(ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0, locationListener);
        }
        else{
            ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }
    }
    public void stopLocationUpdates(){
        locationManager.removeUpdates(locationListener);
    }
    @Override
    public void onLocationChanged(Location location){
        this.longitude = location.getLongitude();
        this.latitude = location.getLatitude();
    }
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras){

    }
    @Override
    public void onProviderEnabled(String provider){

    }
    @Override
    public void onProviderDisabled(String provider){

    }
    public double getLongitude(){
        return this.longitude;
    }
    public double getLatitude(){
        return this.latitude;
    }
}
