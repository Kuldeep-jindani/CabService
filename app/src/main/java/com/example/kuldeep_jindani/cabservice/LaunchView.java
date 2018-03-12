package com.example.kuldeep_jindani.cabservice;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.skyfishjy.library.RippleBackground;

public class LaunchView extends AppCompatActivity {

    Spinner landedview_selection_spinner;
    TextView landview_to,landview_from;
    Typeface typeface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_view);
        landedview_selection_spinner= (Spinner) findViewById(R.id.landedview_selection_spinner);
        landview_from= (TextView) findViewById(R.id.landview_from);
        landview_to= (TextView) findViewById(R.id.landview_to);


        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
            typeface = Typeface.createFromAsset(getAssets(), "font/roboto_light.ttf");

        landview_to.setTypeface(typeface);
        landview_from.setTypeface(typeface);

        String[] abc=getResources().getStringArray(R.array.vehicle_selection);
        ArrayAdapter adapter=new ArrayAdapter(getApplicationContext(),R.layout.landedview_spinner_textview,abc);
        landedview_selection_spinner.setAdapter(adapter);


        final RippleBackground rippleBackground=(RippleBackground)findViewById(R.id.content);
        TextView centerImage=findViewById(R.id.centerImage);
//        TextView imageView= (TextView) findViewById(R.id.landedview_ride);
        rippleBackground.startRippleAnimation();
        centerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(),DriverProfile.class));
            }
        });
    }
}
