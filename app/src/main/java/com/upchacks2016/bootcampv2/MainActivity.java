package com.upchacks2016.bootcampv2;

import android.app.Activity;
import android.content.Intent;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
        Button a = (Button) findViewById(R.id.sidebarButton);

        final Activity activity = this;
        a.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(MainActivity.this, Exercise.class));
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("EGGS R SIDES");

                View view = View.inflate(activity, R.layout.exercisewindow, null);

                builder.setView(view);
                builder.setPositiveButton("OKAY", null);

                AlertDialog dialog = builder.create();
                dialog.show();

                Button b = (Button) view.findViewById(R.id.tName);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(activity);
                        builder2.setTitle("TRAIN OR PRO FEEL");

                        View view2 = View.inflate(activity, R.layout.userwindow, null);

                        builder2.setView(view2);
                        builder2.setPositiveButton("OKAY", null);

                        AlertDialog dialog2 = builder2.create();
                        dialog2.show();
                    }
                });


            }
        }));


        workoutList = (ListView) findViewById(R.id.listView);
        workoutList.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);

        //Creating a preset list of workouts
        final ArrayList<Workout> workouts = new ArrayList<Workout>();
        workouts.add(new Workout("Jacob", new LatLng(41.388756, 2.184864), "Parc de la Ciutadella", "Jogging", new Time(12,30,0)));
        workouts.add(new Workout("Paul", new LatLng(41.3896369,2.1172903), "Parc de la Pedrables", "Sprints", new Time(1,30,0)));
        workouts.add(new Workout("Neil", new LatLng(41.393753,  2.1842620), "Parc de l'Estacio Nord", "Yoga", new Time(15,30,0)));
        workouts.add(new Workout("Jacob", new LatLng(41.3896369,2.1172903), "Parc de la Pedrables", "Jogging", new Time(9,30,0)));

        workoutAdapter adapter = new workoutAdapter(this, workouts);
        workoutList.setAdapter(adapter);
        workoutList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                LatLng location = workouts.get(position).location;
                String locName = workouts.get(position).locName;
                //LatLng location = new LatLng(dlat, dlng);
                Intent goToMap = new Intent(getApplicationContext(), MapsActivity.class);
                Bundle mapInfo = new Bundle();
                mapInfo.putParcelable("location", location);
                mapInfo.putString("locName", locName);
                //goToMap.putExtras("location", location);
                //goToMap.putExtra("locName", locName);
                goToMap.putExtras(mapInfo);
                startActivity(goToMap);
                finish();

            }

        });

    }


}
