package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;


//reads from a csv file the following Type of Activity
// Duration (in minutes)
// Date
// Distance (in kilometers)
// Average Heart Rate

    public class ActivityReader {

        public static void main(String[] args) {
            readFromFile("activity_data_10");

        }

        public static void readFromFile(String fileName) {


            try (Scanner sc = new Scanner(new File(fileName+".csv"))) {
                if (sc.hasNextLine())
                    sc.nextLine();   // read the header line containing column titles, but don't use it


                // Read and discard the header line if it exists
                if (sc.hasNextLine()) {

                    sc.nextLine();


                }
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    System.out.println("Line: " + line); // Debug line
                    String[] data = line.split(";");

                    if (data.length == 5) {
                        ActivityType type = ActivityType.valueOf(data[0]);
                        String dateString = data[2]; // Adjust the index based on the column order in your CSV file
                        double duration = Double.parseDouble(data[1]); // Adjust the index
                        double distance = Double.parseDouble(data[3]); // Adjust the index
                        double averageHeartRate = Double.parseDouble(data[4]); // Adjust the index

                        try {
                            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                            Date date = dateFormat.parse(dateString);

                            // Create an Activity object and do something with it
                            Activity activity = new Activity(type, date, duration, averageHeartRate, distance);
                            //return activity;
                            // You can add it to a list or perform other actions with the activity.
                        } catch (IllegalArgumentException | ParseException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }


            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }}




