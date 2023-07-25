package com.example.weather.main;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.weather.R;
import com.example.weather.main.logic.gps.GpsManager;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button updateGps = (Button) findViewById(R.id.update_gps);
        TextView text = (TextView) findViewById(R.id.textView);
        GpsManager gps = new GpsManager(this);
        gps.startLocationUpdates(this);
        updateGps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText("longitude = " + gps.getLongitude() + " lattitude = " + gps.getLatitude());
            }
        });
    }
}
//TODO: 2) write settings to choose what i want to see
//TODO: 3) encrypt API key