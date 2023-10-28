package org.example;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;

public class ActivityList extends ArrayList<Activity> {

    ArrayList<Activity> activityList;

    public ActivityList() {
        this.activityList = new ArrayList<>();  // instantiate ArrayList object
    }


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

    // Define a sort method for a League object, which uses Collections.sort()
    // to sort the ArrayList based on Natural Ordering of LeagueEntry objects.
    //
    public void sort() {
        Collections.sort(activityList);  // will sort by Natural Ordering
    }


    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public void addActivities(ArrayList<Activity> activities) {
        activityList.addAll(activities);
    }




}