package org.example;

import java.util.Date;

public class Activity {
    private ActivityType activityType;

    private Date date;
    private double duration;
    private double aveHeartRate;
    private String intensity;
    private double caloriesBurned;
    private double distance;

    public Activity() {
    }

    public Activity( ActivityType activityType, Date date, double duration, double aveHeartRate, double distance ) {

        this.activityType = activityType;
        this.date = date;
        this.duration = duration;
        this.aveHeartRate = aveHeartRate;
        this.caloriesBurned = calcCaloriesBurned();
        this.intensity = calcIntensity();
        this.distance = distance;
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

    public String getIntensity() {
        return intensity;
    }

    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }

    public double getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(double caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }
   public String calcIntensity(){
       return "";

   }

    // Calories burned based on energy expended, type of activity and duration
   public double calcCaloriesBurned(){


       if (this.activityType == ActivityType.CYCLING) {
           // Calculate calories burned for cycling

       } else if (this.activityType == ActivityType.RUNNING) {
           // Calculate calories burned for running

       } else if (this.activityType == ActivityType.SWIMMING) {
           // Calculate calories burned for swimming

       }
        return 0.0;
    }

    //Energy expended based on the average kilometres per hour
    public double calcEnergyExpended(){

        return 0.0;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
