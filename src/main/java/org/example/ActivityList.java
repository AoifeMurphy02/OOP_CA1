package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class ActivityList extends ArrayList<Activity> {

    ArrayList<Activity> activityList;

    public ActivityList() {
        this.activityList = new ArrayList<>();  // instantiate ArrayList object
    }


    public void display() {
        for (Activity activity : activityList) {
            System.out.println(activity);
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