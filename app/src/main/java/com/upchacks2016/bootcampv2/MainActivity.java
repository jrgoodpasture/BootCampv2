package com.upchacks2016.bootcampv2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.model.LatLng;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import model.Workout;

public class MainActivity extends AppCompatActivity {

    private ListView workoutList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        workoutList = (ListView) findViewById(R.id.listView);
        ArrayList<Workout> workouts = new ArrayList<Workout>();
        workouts.add(new Workout("Jacob", new LatLng(41.3896369,2.1172903), "Jogging", new Time(12,30,0)));
        workouts.add(new Workout("Jacob", new LatLng(41.3896369,2.1172903), "Jogging", new Time(12,30,0)));
        workouts.add(new Workout("Jacob", new LatLng(41.3896369,2.1172903), "Jogging", new Time(12,30,0)));
        workouts.add(new Workout("Jacob", new LatLng(41.3896369,2.1172903), "Jogging", new Time(12,30,0)));



        workoutAdapter adapter = new workoutAdapter(this, workouts);

        workoutList.setAdapter(adapter);


    }


}
