package com.upchacks2016.bootcampv2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Workout;

public class MainActivity extends AppCompatActivity {

    private ListView workoutList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        workoutList = (ListView) findViewById(R.id.listView);
        workoutList.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);

        //Creating a preset list of workouts
        ArrayList<Workout> workouts = new ArrayList<Workout>();
        workouts.add(new Workout("Jacob", new LatLng(41.3896369,2.1172903), "Jogging", new Time(12,30,0)));
        workouts.add(new Workout("Jacob", new LatLng(41.3896369,2.1172903), "Jogging", new Time(12,30,0)));
        workouts.add(new Workout("Jacob", new LatLng(41.3896369,2.1172903), "Jogging", new Time(12,30,0)));
        workouts.add(new Workout("Jacob", new LatLng(41.3896369,2.1172903), "Jogging", new Time(12,30,0)));

        workoutAdapter adapter = new workoutAdapter(this, workouts);
        workoutList.setAdapter(adapter);
        workoutList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("Clicked!");
                TextView locationText = (TextView) view.findViewById(R.id.locationText);
                String locString = locationText.toString();
                List<String> latLong = Arrays.asList(locString.split(","));
                String lat = latLong.get(0);
                String lng = latLong.get(1);
                LatLng location = new LatLng(Double.parseDouble(lat), Double.parseDouble(lng));
                Intent goToMap = new Intent(getApplicationContext(), MapsActivity.class);
                goToMap.putExtra("location", location);
                startActivity(goToMap);
                finish();

            }

        });

    }


}
