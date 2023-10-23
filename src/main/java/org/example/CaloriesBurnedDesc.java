package org.example;

import java.util.Comparator;

public class CaloriesBurnedDesc  implements Comparator<Activity> {

    @Override
    public int compare(Activity o1, Activity o2) {
        return (int) (o2.calcCaloriesBurned()-o1.calcCaloriesBurned());
    }


}
