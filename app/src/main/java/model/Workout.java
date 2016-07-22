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
    public String locName;
    public String activity;
    public Time time;

    //Constructor
    public Workout(String trainerName, LatLng location, String locName, String activity, Time time) {
        this.trainerName = trainerName;
        this.location = location;
        this.locName = locName;
        this.activity = activity;
        this.time = time;
    }

}
