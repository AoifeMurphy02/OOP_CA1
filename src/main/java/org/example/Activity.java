package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Activity implements Comparable<Activity> {

  /**  public static void main(String[] args) throws ParseException {
        String dateString = "10/10/2022";
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = dateFormat.parse(dateString);

        Activity a = new Activity(ActivityType.valueOf("RUNNING"), date, 17, 125, 20);
        System.out.println(a);
    }
   */
    private ActivityType activityType;

    private Date date;
    private double duration;
    private double aveHeartRate;
    private String intensity;
    private double caloriesBurned;
    private double distance;


    public Activity() {
    }



     public Activity(ActivityType activityType, Date date, double duration, double aveHeartRate, double distance) {
            this.activityType = activityType;
            this.date = date;
            this.duration = duration;
            this.aveHeartRate = aveHeartRate;
            this.distance = distance;
         this.intensity = calcIntensity(); // Set the intensity based on the provided data
         this.caloriesBurned = calcCaloriesBurned(); // Calculate calories burned based on intensity
        }


    public String getIntensity() {
        return intensity;
    }

    public double getCaloriesBurned() {
        return caloriesBurned;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getAveHeartRate() {
        return aveHeartRate;
    }

    public void setAveHeartRate(double aveHeartRate) {
        this.aveHeartRate = aveHeartRate;
    }



    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }



    public void setCaloriesBurned(double caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }
    public String calcIntensity() {
        double km = this.distance / this.duration * 60;
        if (this.activityType == ActivityType.SWIMMING) {
            if (km < 0.5) {
                return "Very Light";
            } else if (km > 0.5 && km <= 1.25) {
                return "Light";
            } else if (km > 1.25 && km <= 2) {
                return "Moderate";
            } else if (km > 2 && km <= 2.75) {
                return "Vigorous";
            } else if (km > 2.75 && km <= 3.5) {
                return "Very Vigorous";
            }
        }
        if (this.activityType == ActivityType.RUNNING) {
            if (km <= 4) {
                return "Very Light";
            } else if (km > 4 && km <= 8) {
                return "Light";
            } else if (km > 8 && km <= 12) {
                return "Moderate";
            } else if (km > 12 && km <= 16) {
                return "Vigorous";
            } else if (km > 16 && km <= 24) {
                return "Very Vigorous";
            }
        }
        if (this.activityType == ActivityType.CYCLING) {
            if (km <= 8) {
                return "Very Light";
            } else if (km > 8 && km <= 16) {
                return "Light";
            } else if (km > 16 && km <= 25) {
                return "Moderate";
            } else if (km > 25 && km <= 33) {
                return "Vigorous";
            } else if (km > 33 && km <= 40) {
                return "Very Vigorous";
            }
        }
        return "null";
    }

    // Calories burned based on energy expended, type of activity and duration
    public double calcCaloriesBurned() {
        double intensity_value = 0.0;

        if (intensity.equals("Very Light")) {
            intensity_value = 2;
        } else if (intensity.equals("Light")) {
            intensity_value = 5;
        } else if (intensity.equals("Moderate")) {
            intensity_value = 7;
        } else if (intensity.equals("Vigorous")) {
            intensity_value = 13;
        } else if (intensity.equals("Very Vigorous")) {
            intensity_value = 15;
        }

        return intensity_value * this.duration;
    }

    //Energy expended based on the average kilometres per hour
   // public double calcEnergyExpended(){

     //return 0.0;
  //}

    public double getDistance() {
        return distance;
    }

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



    @Override
    public int compareTo(Activity o) {
        return this.date.compareTo(o.date);
    }
}
