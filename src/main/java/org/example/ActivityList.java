package org.example;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;

public class ActivityList extends ArrayList<Activity> {

    ArrayList<Activity> activityList;
    /**
     * Creates an empty ActivityList.
     */
    public ActivityList() {
        this.activityList = new ArrayList<>();  // instantiate ArrayList object
    }

    /**
     * Display method to display the activities.
     */
    public void display() {
        String header = String.format("%-15s %-12s %-14s %-14s %-12s %-15s %-12s",
                "Activity Type", "Date", "Duration", "Avg Heart Rate", "Intensity", "Calories Burned", "Distance");

        System.out.println(header);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (Activity activity : activityList) {
            String activityRow = String.format("%-15s %-12s %-14s %-14s %-12s %-15s %-12s",
                    activity.getActivityType(),
                    dateFormat.format(activity.getDate()),
                    String.format("%.2f min", activity.getDuration()),
                    String.format("%.2f bpm", activity.getAveHeartRate()),
                    activity.getIntensity(),
                    String.format("%.2f kcal", activity.getCaloriesBurned()),
                    String.format("%.2f km", activity.getDistance()));

            System.out.println(activityRow);
        }
    }

    /**
     * sorts activities based on the natural ordering
     */
    public void sort() {
        Collections.sort(activityList);  // will sort by Natural Ordering
    }

    /**
     * adds an activity to the list
     * @param activity to be added to the list
     */
    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    /**
     * adds a list of activities to the list
     * @param activities the list of activities to be added
     */
    public void addActivities(ArrayList<Activity> activities) {
        activityList.addAll(activities);
    }




}