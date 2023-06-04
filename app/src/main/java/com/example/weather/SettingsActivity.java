package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Intent intentToMainActivity = new Intent(SettingsActivity.this, MainActivity.class);
        Button apply = (Button) findViewById(R.id.ApplyButton);
        Button exit = (Button) findViewById(R.id.ExitButton);
        exit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
                startActivity(intentToMainActivity);
            }
        });
        apply.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
                boolean[] setting_choise = new boolean[] {
                        ((CheckBox) findViewById(R.id.WindInfo)).isChecked(),
                        ((CheckBox) findViewById(R.id.CloudsInfo)).isChecked(),
                        ((CheckBox) findViewById(R.id.VisibilityInfo)).isChecked(),
                        ((CheckBox) findViewById(R.id.SunsetInfo)).isChecked(),
                        ((CheckBox) findViewById(R.id.PressureInfo)).isChecked(),
                        ((CheckBox) findViewById(R.id.HumidityInfo)).isChecked(),
                };
                intentToMainActivity.putExtra("hui", setting_choise);
                startActivity(intentToMainActivity);
            }
        });

    }
}