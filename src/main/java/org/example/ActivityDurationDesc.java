package org.example;

import java.util.Comparator;

public class ActivityDurationDesc implements Comparator<Activity> {
    @Override
    public int compare(Activity o1, Activity o2) {
        return (int) (o2.getDuration() - o1.getDuration());
    }
}
