package com.example.weather.main;

import android.os.Bundle;
import android.provider.Settings;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.weather.R;
import com.example.weather.main.logic.gps.GpsManager;

public class MainActivity extends AppCompatActivity{
    GpsManager gpsManager;
    String id;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        gpsManager = new GpsManager(this);
        id = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
        textView.setText(id);
        gpsManager.startLocationUpdates(this);
    }
    protected void onPause(Bundle savedInstanceState){
        gpsManager.stopLocationUpdates();
    }
}
//TODO: 2) write settings to choose what i want to see
//TODO: 3) encrypt API key