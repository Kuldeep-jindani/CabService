package com.example.kuldeep_jindani.cabservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Selection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        Button launchView=findViewById(R.id.launchView);

        launchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),LaunchView.class));
            }
        });

        Button Vehicle=findViewById(R.id.Vehicle);

        Vehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Vehicle.class));
            }
        });
        Button Location=findViewById(R.id.Location);
        Button driverProfile=findViewById(R.id.driverProfile);
        Button LocationFilled=findViewById(R.id.LocationFilled);
        Button mainActivity=findViewById(R.id.mainActivity);

        Location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Location.class));
            }
        });
        LocationFilled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),LocationFilled.class));
            }
        });
        driverProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),DriverProfile.class));
            }
        });
        mainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }
}
