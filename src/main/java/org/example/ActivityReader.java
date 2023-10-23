package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


//reads from a csv file the following Type of Activity
// Duration (in minutes)
// Date
// Distance (in kilometers)
// Average Heart Rate

    public class ActivityReader {

        public static void main(String[] args) {
            readFromFile("activity_data_10");

        }

        public static ActivityList readFromFile(String fileName) {
            ActivityList activities = new ActivityList();

            try (Scanner sc = new Scanner(new File(fileName + ".csv"))) {
                if (sc.hasNextLine())
                    sc.nextLine();   // read the header line containing column titles, but don't use it

                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                   //System.out.println("Line: " + line); // Debug line
                    String[] data = line.split(",");

                        ActivityType type = ActivityType.valueOf(data[0].toUpperCase());
                        String dateString = data[1]; // Adjust the index based on the column order in your CSV file
                        double duration = Double.parseDouble(data[2]); // Adjust the index
                        double distance = Double.parseDouble(data[3]); // Adjust the index
                        double averageHeartRate = Double.parseDouble(data[4]); // Adjust the index



                        try {
                            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                            Date date = dateFormat.parse(dateString);
                            Activity activity = new Activity(type, date, duration, averageHeartRate, distance);

                            // Set Intensity and CaloriesBurned after distance and duration are set
                            activity.setIntensity(activity.calcIntensity());
                            activity.setCaloriesBurned(activity.calcCaloriesBurned());
                            activities.addActivity(activity);
                        } catch (IllegalArgumentException | ParseException e) {
                            throw new RuntimeException(e);
                        }
                    }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            return activities;
        }




    }




