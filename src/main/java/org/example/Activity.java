package org.example;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Activity implements Comparable<Activity> {

    private ActivityType activityType;
    private Date date;
    private double duration;
    private double aveHeartRate;
    private String intensity;
    private double caloriesBurned;
    private double distance;

    /**
     * Instantiates a new Activity.
     */

    public Activity() {
    }


    /**
     * Instantiates a new Activity.
     *
     * @param activityType the activity type
     * @param date         the date
     * @param duration     the duration
     * @param aveHeartRate the ave heart rate
     * @param distance     the distance
     */
    public Activity(ActivityType activityType, Date date, double duration, double aveHeartRate, double distance) {
            this.activityType = activityType;
            this.date = date;
            this.duration = duration;
            this.aveHeartRate = aveHeartRate;
            this.distance = distance;
            this.intensity = calcIntensity(); // Set the intensity based on the provided data
            this.caloriesBurned = calcCaloriesBurned(); // Calculate calories burned based on intensity
        }


    /**
     * Gets intensity.
     * @return the intensity
     */
    public String getIntensity() {
        return intensity;
    }

    /**
     * Gets calories burned.
     * @return the calories burned
     */
    public double getCaloriesBurned() {
        return caloriesBurned;
    }

    /**
     * Gets activity type.
     * @return the activity type
     */
    public ActivityType getActivityType() {
        return activityType;
    }

    /**
     * Sets activity type.
     * @param activityType the activity type
     */
    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    /**
     * Gets date.
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets date.
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets duration.
     * @return the duration
     */
    public double getDuration() {
        return duration;
    }

    /**
     * Sets duration.
     * @param duration the duration
     */
    public void setDuration(double duration) {
        this.duration = duration;
    }

    /**
     * Gets ave heart rate.
     * @return the ave heart rate
     */
    public double getAveHeartRate() {
        return aveHeartRate;
    }

    /**
     * Sets ave heart rate.
     * @param aveHeartRate the ave heart rate
     */
    public void setAveHeartRate(double aveHeartRate) {
        this.aveHeartRate = aveHeartRate;
    }


    /**
     * Sets intensity.
     * @param intensity the intensity
     */
    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }


    /**
     * Sets calories burned.
     * @param caloriesBurned the calories burned
     */
    public void setCaloriesBurned(double caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    public static void main(String[] args) {
        Activity a1 = new Activity(ActivityType.SWIMMING,new Date(01/05/2020),120,150,7.37);
        System.out.println(a1.calcIntensity());
    }

    /**
     * Calc intensity.
     * Calculates the intensity of an activity based on the distance and duration.
     * The intensity is categorized as Very Light, Light, Moderate, Vigorous, or Very Vigorous.
     * @return the intensity as a string or "null" if the activity type is not recognized.
     */
    public String calcIntensity() {
        //get the speed in kilometers per minute
        String intensity = "Very Light";
        double km = this.distance / this.duration * 60;
        // Check to see the activity type to determine intensity
        switch (this.activityType) {
            case SWIMMING:
                if (true == km >= 0.5 && km <= 1.25) {
                    intensity = "Light";
                } else if (true == km <= 2) {
                    intensity = "Moderate";
                } else if (true == km <= 2.75) {
                    intensity = "Vigorous";
                } else if (true == km <= 3.5) {
                    intensity = "Very Vigorous";
                }
                break;
        }

                switch (this.activityType) {
                    case RUNNING:
            if (km >= 4 && km <= 8) {
                intensity = "Light";
            } else if (km > 8 && km <= 12) {
                intensity = "Moderate";
            } else if (km > 12 && km <= 16) {
                intensity = "Vigorous";
            } else if (km > 16 && km <= 24) {
                intensity = "Very Vigorous";
            }
            break;
        }switch (this.activityType) {
            case CYCLING:
            if (km >= 8 && km <= 16) {
                intensity = "Light";
            } else if (km > 16 && km <= 25) {
                intensity = "Moderate";
            } else if (km > 25 && km <= 33) {
                intensity = "Vigorous";
            } else if (km > 33 && km <= 40) {
                intensity = "Very Vigorous";
            }
            break;
        }
        //return the intensity
        return intensity;
    }

    /**
     * Calculates the calories burned during an activity based on its intensity and duration.
     * @return The total calories burned as a double value
     */
    public double calcCaloriesBurned() {
        double calories = 0.0;
        // Check the intensity to determine the calorie burn rate
        if (intensity != null) {
            switch (intensity) {
               case "Very Light":
                    calories = 2;
                    break;
                case "Light":
                    calories = 5;
                    break;
                case "Moderate":
                    calories = 7;
                case "Vigorous":
                    calories = 13;
                    break;
                case "Very Vigorous":
                    calories = 15;
                    break;
                }
            }

        //get the calories burned by multiplying the calorie burn rate by the duration
        return calories * this.duration;
    }

    /**
     * Gets distance.
     * @return the distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Sets distance.
     * @param distance the distance
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "Activity{" +
                "activityType=" + activityType +
                ", date=" + dateFormat.format(date) +
                ", duration=" + String.format("%.2f", duration) + " minutes" +
                ", aveHeartRate=" + String.format("%.2f", aveHeartRate) +
                ", intensity='" + intensity + '\'' +
                ", caloriesBurned=" + String.format("%.2f", caloriesBurned) +
                ", distance=" + String.format("%.2f", distance) + " kilometers" +
                '}';
    }

    /**
     * Compares this Activity to another Activity based on their dates
     *@param o The Activity object to compare to.
     *@return A negative integer, zero, or a positive integer if this Activity's date is
     * less than, equal to, or greater than the date of the provided Activity.
     */
    @Override
    public int compareTo(Activity o) {
        return this.date.compareTo(o.date);
    }
}
