package com.upchacks2016.bootcampv2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import model.Workout;

/**
 * Created by Jacob on 7/21/2016.
 */
public class workoutAdapter extends ArrayAdapter<model.Workout>{
    public workoutAdapter(Context context, ArrayList<Workout> workouts) {
        super(context, 0, workouts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Workout workout = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_row_layout, parent, false);
        }
        // Lookup view for data population
        TextView trainerName = (TextView) convertView.findViewById(R.id.trainerName);
        TextView locationText = (TextView) convertView.findViewById(R.id.locationText);
        TextView activityText = (TextView) convertView.findViewById(R.id.activityText);
        TextView timeText = (TextView) convertView.findViewById(R.id.timeText);
        // Populate the data into the template view using the data object
        trainerName.setText(workout.trainerName);
        locationText.setText(workout.location.toString());
        activityText.setText(workout.activity);
        timeText.setText(workout.time.toString());
        // Return the completed view to render on screen
        return convertView;
    }


}
