package com.upchacks2016.bootcampv2;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.sql.Time;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Intent i = getIntent();
        LatLng location = i.getParcelableExtra("location");
        final String locName = i.getStringExtra("locName");
        final String trainerName = i.getStringExtra("trainerName");
        final String workoutActivity = i.getStringExtra("activity");
        final Time time = (Time) i.getSerializableExtra("time");

        // Add a marker in Sydney and move the camera
        //LatLng location = new LatLng(41.3896369,2.1172903);
        mMap.addMarker(new MarkerOptions().position(location).title(locName));

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(location)      // Sets the center of the map to Mountain View
                .zoom(17)                   // Sets the zoom
                .bearing(90)                // Sets the orientation of the camera to east
                .tilt(30)                   // Sets the tilt of the camera to 30 degrees
                .build();                   // Creates a CameraPosition from the builder
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        final Activity activity = this;
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle(workoutActivity);

                View view = View.inflate(activity, R.layout.exercisewindow, null);

                TextView trainerNameText = (TextView) view.findViewById(R.id.trainerNameText);
                trainerNameText.setText(trainerName);
                TextView timeText = (TextView) view.findViewById(R.id.timeText);
                timeText.setText("Time: " + time.toString());
                TextView placeText = (TextView) view.findViewById(R.id.placeText);
                placeText.setText(locName);

                builder.setView(view);
                builder.setPositiveButton("OKAY", null);

                AlertDialog dialog = builder.create();
                dialog.show();

                /*Button b = (Button) view.findViewById(R.id.tName);
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
                });*/
                return true;
            }
        });
    }

    public void onBackPressed() {
        Intent goToMainActivity = new Intent(this, MainActivity.class);
        startActivity(goToMainActivity);
        finish();
    }
}
