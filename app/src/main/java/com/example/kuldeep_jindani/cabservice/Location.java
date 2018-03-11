package com.example.kuldeep_jindani.cabservice;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class Location extends Activity {

    LinearLayout locationResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        locationResult=findViewById(R.id.locationResult);

        View v= LayoutInflater.from(getApplicationContext()).inflate(R.layout.location_list_layout,null);
        View v1= LayoutInflater.from(getApplicationContext()).inflate(R.layout.location_list_layout,null);
        View v2= LayoutInflater.from(getApplicationContext()).inflate(R.layout.location_list_layout,null);
        View v3= LayoutInflater.from(getApplicationContext()).inflate(R.layout.location_list_layout,null);
        View v4= LayoutInflater.from(getApplicationContext()).inflate(R.layout.location_list_layout,null);
        View v5= LayoutInflater.from(getApplicationContext()).inflate(R.layout.location_list_layout,null);
        View v6= LayoutInflater.from(getApplicationContext()).inflate(R.layout.location_list_layout,null);

//        for (int i=0;i<6;i++){
            locationResult.addView(v);
            locationResult.addView(v1);
            locationResult.addView(v2);
            locationResult.addView(v3);
            locationResult.addView(v4);
            locationResult.addView(v5);
            locationResult.addView(v6);



    }
}
