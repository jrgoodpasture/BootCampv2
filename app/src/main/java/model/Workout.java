package model;

import com.google.android.gms.maps.model.LatLng;

import java.sql.Time;

/**
 * Created by Jacob on 7/22/2016.
 */
public class Workout {
    //declaring variables

    public String trainerName;
    public LatLng location;
    public String activity;
    public Time time;

    //Constructor
    public Workout(String trainerName, LatLng location, String activity, Time time) {
        this.trainerName = trainerName;
        this.location = location;
        this.activity = activity;
        this.time = time;
    }

}
