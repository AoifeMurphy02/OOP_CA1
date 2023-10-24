package org.example;

import java.util.Comparator;

public class ActivityDurationAsc implements Comparator<Activity> {
    @Override
    public int compare(Activity o1, Activity o2) {
        return (int) (o1.getDuration() - o2.getDuration());
    }
}
