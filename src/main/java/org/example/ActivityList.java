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


    /**
     * gets the average Calories Burned for all activity's in an ActivityList passed to it
     * @param list
     * @return a double the average Calories Burned of the activies in the list
     */
    public static double getAvgCaloriesBurned(ActivityList list){
        double totalCaloriesBurned =0;
        int count =0;
        for (Activity activity : list.activityList) {
            totalCaloriesBurned += activity.getCaloriesBurned();
            count ++;
        }
        return totalCaloriesBurned/count;

    }
    /**
     * gets the average distance for all activity's in an ActivityList passed to it
     * @param list
     * @return a double the average distance of the activies in the list
     */
    public static double getAvgDistance(ActivityList list){
        double totalDistance =0;
        int count =0;
        for (Activity activity : list.activityList) {
            totalDistance += activity.getDistance();
            count ++;
        }
        return totalDistance/count;

    }
    /**
     * Creates an Activity list of all Activity's with the Activity Type of Cycling from the activityList passed to it
     * @param activityList
     * @return an ActivityList of all the Activity's with the Activity Type of Cycling
     */
    public static ActivityList allCycling(ActivityList activityList) {
        //create a new ActivityList this will hold all the Activity with the type of cycling
        ActivityList cycling = new ActivityList();
        //iterate through the activityList
        for (Activity activity : activityList.activityList) {
            //if its of type Cycling
            if (activity.getActivityType() == ActivityType.CYCLING) {
                //add it to the new ActivityList
                cycling.addActivity(activity);
            }
        }
        return cycling;

    }
    /**
     * Creates an Activity list of all Activity's with the Activity Type of swimming from the activityList passed to it
     * @param activityList
     * @return an ActivityList of all the Activity's with the Activity Type of swimming
     */
    public static ActivityList allSwimming(ActivityList activityList){
        ActivityList swimming = new ActivityList();
        for (Activity activity : activityList.activityList) {
            if (activity.getActivityType() == ActivityType.SWIMMING) {
                swimming.addActivity(activity);
            }
        }
        return swimming;
    }
    /**
     * Creates an Activity list of all Activity's with the Activity Type of running from the activityList passed to it
     * @param activityList
     * @return an ActivityList of all the Activity's with the Activity Type of running
     */
    public static ActivityList allRunning(ActivityList activityList){
        ActivityList running = new ActivityList();
        for (Activity activity : activityList.activityList) {
            if (activity.getActivityType() == ActivityType.RUNNING) {
                running.addActivity(activity);
            }
        }
        return  running;
    }


}