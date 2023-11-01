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
        /**
         * reads data from a CSV file and creates an ActivityList containing the data
         * @param fileName the filename of the file we are reading the data from
         * @return an ActivityList filled with the data read from the file passed to the method
         */
        public static ActivityList readFromFile(String fileName) {
            //create an empty  ActivityList to store the activities taken from the csv file
            ActivityList activities = new ActivityList();

            try (Scanner sc = new Scanner(new File(fileName + ".csv"))) {
                // read the header line containing the titles, but we don't use it
                if (sc.hasNextLine())
                    sc.nextLine();
                //while there is a next line read the next line from the CSV file.
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    // Split the line into an array of data values using "," as the separator.
                    String[] data = line.split(",");
                        // Parse the data from the CSV file.
                        ActivityType type = ActivityType.valueOf(data[0].toUpperCase());//use to uppercase as the ActivityType is saved as an uppercase string
                        String dateString = data[1];
                        double duration = Double.parseDouble(data[2]);
                        double distance = Double.parseDouble(data[3]);
                        double averageHeartRate = Double.parseDouble(data[4]);




                        try {
                            // Define the date format
                            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                            //parse the date string into a Date object
                            Date date = dateFormat.parse(dateString);
                            //create a new Activity with the data taken from the CSV file
                            Activity activity = new Activity(type, date, duration, averageHeartRate, distance);

                            // Set Intensity and CaloriesBurned after distance and duration are set
                            activity.setIntensity(activity.calcIntensity());
                            activity.setCaloriesBurned(activity.calcCaloriesBurned());
                            //Add the activity to the ActivityList
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




