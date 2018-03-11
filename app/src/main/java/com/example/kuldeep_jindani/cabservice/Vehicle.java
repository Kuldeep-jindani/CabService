package com.example.kuldeep_jindani.cabservice;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.kuldeep_jindani.cabservice.Adapter.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Vehicle extends AppCompatActivity {

    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    ExpandableListView vehicle_expandable;
    ExpandableListAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        vehicle_expandable=findViewById(R.id.vehicle_expandable);

prepareListData();


    }


    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Anything");
        listDataHeader.add("Cab");
        listDataHeader.add("3 wheeler");
        listDataHeader.add("Bikes");
        listDataHeader.add("Commercial");
        listDataHeader.add("Heavy");

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("The Shawshank Redemption");
        top250.add("The Godfather");
        top250.add("The Godfather: Part II");
        top250.add("Pulp Fiction");
        top250.add("The Good, the Bad and the Ugly");
        top250.add("The Dark Knight");
        top250.add("12 Angry Men");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("The Conjuring");
        nowShowing.add("Despicable Me 2");
        nowShowing.add("Turbo");
        nowShowing.add("Grown Ups 2");
        nowShowing.add("Red 2");
        nowShowing.add("The Wolverine");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("2 Guns");
        comingSoon.add("The Smurfs 2");
        comingSoon.add("The Spectacular Now");
        comingSoon.add("The Canyons");
        comingSoon.add("Europa Report");

        List<String> nowShowing1= new ArrayList<String>();
        nowShowing1.add("The Conjuring");
        nowShowing1.add("Despicable Me 2");
        nowShowing1.add("Turbo");
        nowShowing1.add("Grown Ups 2");
        nowShowing1.add("Red 2");
        nowShowing1.add("The Wolverine");

        List<String> comingSoon1 = new ArrayList<String>();
        comingSoon1.add("2 Guns");
        comingSoon1.add("The Smurfs 2");
        comingSoon1.add("The Spectacular Now");
        comingSoon1.add("The Canyons");
        comingSoon1.add("Europa Report");

        List<String> nowShowing2 = new ArrayList<String>();
        nowShowing2.add("The Conjuring");
        nowShowing2.add("Despicable Me 2");
        nowShowing2.add("Turbo");
        nowShowing2.add("Grown Ups 2");
        nowShowing2.add("Red 2");
        nowShowing2.add("The Wolverine");



        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
        listDataChild.put(listDataHeader.get(3), nowShowing1);
        listDataChild.put(listDataHeader.get(4), comingSoon1);
        listDataChild.put(listDataHeader.get(5), nowShowing2);

        List<Drawable> images=new ArrayList();
        images.add(null);
        images.add(getResources().getDrawable(R.drawable.ic_car));
        images.add(getResources().getDrawable(R.drawable.tuk_tuk));
        images.add(getResources().getDrawable(R.drawable.ic_bike));
        images.add(getResources().getDrawable(R.drawable.van_2));
        images.add(getResources().getDrawable(R.drawable.bulldozer));

        listAdapter = new ExpandableListAdapter(getApplicationContext(), listDataHeader, listDataChild,vehicle_expandable,images);

        // setting list adapter
        vehicle_expandable.setAdapter(listAdapter);
    }
}
