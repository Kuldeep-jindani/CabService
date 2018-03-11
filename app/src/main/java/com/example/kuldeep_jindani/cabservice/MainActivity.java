package com.example.kuldeep_jindani.cabservice;

import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    // Google Map
    private GoogleMap googleMap;
    LinearLayout rideSearching,rideFound,driverLayout;
    TextView driverIsCming,VehicleNmber,mins;
    Typeface typeface;
    ImageView mainActivity_menu;
    Menu m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        rideSearching=findViewById(R.id.rideSearching);
        rideFound=findViewById(R.id.rideFound);
        driverLayout=findViewById(R.id.driverLayout);
        mainActivity_menu=findViewById(R.id.mainActivity_menu);


        driverIsCming=findViewById(R.id.driverIsCming);
        VehicleNmber=findViewById(R.id.VehicleNmber);
        mins=findViewById(R.id.mins);

        typeface = Typeface.createFromAsset(getAssets(), "font/roboto_light.ttf");

        driverIsCming.setTypeface(typeface);
        VehicleNmber.setTypeface(typeface);
        mins.setTypeface(typeface);


        mainActivity_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.mainscreen_menu_layout);
                dialog.setTitle("Options");
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                dialog.show();
                    }
                }, 200);

            }
        });

        rideFound.setVisibility(View.GONE);
        //rideSearching.setVisibility(View.GONE);
        driverLayout.setVisibility(View.GONE);


        final Animation bottomUp = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.bottom_up);
        rideSearching.startAnimation(bottomUp);
        rideSearching.setVisibility(View.VISIBLE);



        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after 100ms


        Animation bottomDown = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.bottom_down);
//        rideSearching.startAnimation(bottomDown);
        rideSearching.setVisibility(View.GONE);

                rideFound.startAnimation(bottomUp);
                rideFound.setVisibility(View.VISIBLE);

                driverLayout.startAnimation(bottomUp);
                driverLayout.setVisibility(View.VISIBLE);




            }
        }, 2000);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Add a marker in Sydney, Australia,
        // and move the map's camera to the same location. 23.036293, 72.523265
        LatLng sydney = new LatLng(23.036293, 72.523265);
        googleMap.addMarker(new MarkerOptions().position(sydney)
                .title("Your Location"));
        googleMap.getMaxZoomLevel();
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }



}
