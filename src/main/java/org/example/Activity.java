package org.example;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Activity implements Comparable<Activity> {

    private ActivityType activityType;
    private Date date;
    private double duration;
    private double aveHeartRate;
    private Intensity intensity;
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


    public Intensity getIntensity() {
        return intensity;
    }

    public void setIntensity(Intensity intensity) {
        this.intensity = intensity;
    }


    /**
     * Sets calories burned.
     * @param caloriesBurned the calories burned
     */
    public void setCaloriesBurned(double caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }


    /**
     * Calc intensity.
     * Calculates the intensity of an activity based on the distance and duration.
     * The intensity is categorized as Very Light, Light, Moderate, Vigorous, or Very Vigorous.
     * @return the intensity as a string or "null" if the activity type is not recognized.
     */
    public Intensity calcIntensity() {
        //get the speed in kilometers per minute
       Intensity intensity = Intensity.VERY_LIGHT;
        double km = this.distance / this.duration * 60;
        // Check to see the activity type to determine intensity
        switch (this.activityType) {
            case SWIMMING:
                if ( km >= 0.5 && km <= 1.25) {
                    intensity = Intensity.LIGHT;
                } else if (km <= 2) {
                    intensity = Intensity.MODERATE;
                } else if (km <= 2.75) {
                    intensity = Intensity.VIGOROUS;
                } else if ( km <= 3.5) {
                    intensity = Intensity.VERY_VIGOROUS;
                }
                break;
        }

                switch (this.activityType) {
                    case RUNNING:
            if (km >= 4 && km <= 8) {
                intensity = Intensity.LIGHT;
            } else if (km > 8 && km <= 12) {
                intensity = Intensity.MODERATE;
            } else if (km > 12 && km <= 16) {
                intensity = Intensity.VIGOROUS;
            } else if (km > 16 && km <= 24) {
                intensity = Intensity.VERY_VIGOROUS;
            }
            break;
        }switch (this.activityType) {
            case CYCLING:
            if (km >= 8 && km <= 16) {
                intensity = Intensity.LIGHT;
            } else if (km > 16 && km <= 25) {
                intensity = Intensity.MODERATE;
            } else if (km > 25 && km <= 33) {
                intensity = Intensity.VIGOROUS;
            } else if (km > 33 && km <= 40) {
                intensity = Intensity.VERY_VIGOROUS;
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
                case VERY_LIGHT:
                    switch (activityType){
                        case CYCLING:
                            calories = 2;
                            break;
                        case SWIMMING:
                            calories = 5;
                            break;
                        case RUNNING:
                            calories = 4.1;
                            break;
                    }
                    break;
                case LIGHT:
                    switch (activityType){
                        case CYCLING:
                            calories = 5;
                            break;
                        case SWIMMING:
                            calories = 6.3;
                            break;
                        case RUNNING:
                            calories = 7.2 ;
                            break;
                    }
                    break;
                case MODERATE:
                    switch (activityType) {
                        case CYCLING:
                            calories = 7;
                            break;
                        case RUNNING:
                            calories = 10;
                            break;
                        case SWIMMING:
                            calories = 7.6;
                            break;
                    }
                case VIGOROUS:
                    switch (activityType) {
                        case CYCLING:
                            calories = 13;
                            break;
                        case RUNNING:
                            calories = 15.4;
                            break;
                        case SWIMMING:
                            calories = 8.9;
                            break;
                    }
                    break;
                case VERY_VIGOROUS:
                    switch (activityType) {
                        case CYCLING:
                            calories = 15;
                            break;
                        case RUNNING:
                            calories = 20.8;
                            break;
                        case SWIMMING:
                            calories = 10.2;
                            break;
                    }
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
