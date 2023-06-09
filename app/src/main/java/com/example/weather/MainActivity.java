package com.example.weather;

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

public class MainActivity extends AppCompatActivity implements LocationListener {
    private static final int REQUEST_LOCATION_PERMISSION = 1;
    private static final boolean[] ZERO = {false, false, false, false, false, false};
    private static boolean[] settingsStatus = ZERO;
    private LocationManager locationManager;
    protected LocationListener locationListener;
    private Location location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_PERMISSION);
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_PERMISSION);
        }
        Intent myIntent = new Intent(MainActivity.this, SettingsActivity.class);
        Button settings = (Button) findViewById(R.id.SettingsButton);
        Button refresh = (Button) findViewById(R.id.RefreshButton);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        refresh.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n") // хз зач, говорит, что надо
            @Override
            public void onClick(View view) {
                TextView showOnDisplay = (TextView) findViewById(R.id.weatherTextView);
                settingsStatus = getIntent().getBooleanArrayExtra("hui");
                if (settingsStatus == null)
                    settingsStatus = ZERO;
                showOnDisplay.setText("Updating...\n with:\nWind = " + settingsStatus[0]
                        + "\nClouds = " + settingsStatus[1] + "\nVisibility = " + settingsStatus[2]
                        + "\nSunset/rise = " + settingsStatus[3] + "\nPressure = " + settingsStatus[4]
                        + "\nFeels like = " + settingsStatus[5]);
                GetWeather getWeather = new GetWeather();
                //location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                getWeather.setCoords(location.getLatitude(), location.getLongitude());
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String json;
                            json = getWeather.getWeatherData();
                            JsonWeather weather = new JsonWeather();
                            if (json != null) {
                                weather = JsonWeather.fromJson(json);
                                String showWeather = "timezone = " + weather.timezone + "\n";
                                if (settingsStatus[0]) { // Wind info
                                    showWeather += "Wind:   " + "speed = " + weather.wind.speed + ", deg = "
                                            + weather.wind.deg + "\n";
                                }
                                if (settingsStatus[1]) {// Clouds info
                                    showWeather += "Clouds = " + weather.clouds.all + "\n";
                                }
                                if (settingsStatus[2]) { // Visibility info
                                    showWeather += "Visibility = " + Integer.toString(weather.visibility) + "m\n";
                                }
                                if (settingsStatus[3]) { // Sunset info
                                    showWeather += "Sunset = " + weather.sys.sunrise + "s, sunset = "
                                            + weather.sys.sunset + "s\n";
                                }
                                if (settingsStatus[4]) { // Pressure info
                                    showWeather += "Pressure = " + weather.main.pressure + "\n";
                                }
                                if (settingsStatus[5]) { // Humidity info
                                    showWeather += "Feels like = " + Double.toString(weather.main.feels_like) + "\n";
                                }
                                if (settingsStatus == ZERO) {
                                    showWeather = "Please select some settings";
                                }
                                showOnDisplay.setText(showWeather);
                            } else {
                                showOnDisplay.setText("Connection error");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();
            }
        });


        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(myIntent);
            }
        });

        //locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.d("Latitude", "disable");
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.d("Latitude", "enable");
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.d("Latitude", "status");
    }
}
//TODO: 2) write settings to choose what i want to see
//TODO: 3) encrypt API key