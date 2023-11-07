package org.example;


import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        ActivityList activityList = new ActivityList();
        //activityList = ActivityReader.readFromFile("activity_data_10");
        //activityList = ActivityReader.readFromFile("activity_data_50");
        //activityList = ActivityReader.readFromFile("activity_data_100");
        // activityList = ActivityReader.readFromFile("activity_data_1000");

        Scanner kb = new Scanner(System.in);
        boolean fileFound = false;
        do {
            System.out.println("Enter the file name");
            String file = kb.next();

            try {
                activityList = ActivityReader.readFromFile(file);
                fileFound = true;
            } catch (Exception e) {
                System.out.println("File not found");
            }
        } while (!fileFound);

        String[] menuType = {"0. Exit",
                "1. View your Activity in different orders",
                "2. View a Subset of Your Activity",
                "3. View statistics on their overall performance"
        };
        int choice = -1;
        do {
            displayMenu(menuType, "Choose an option");

            try {
                choice = getMenuChoice(menuType.length);
                switch (choice) {
                    case 1:
                        String[] menuOptions = {"0. Exit", "1. Calories burned (Descending)",
                                "2. Date (Ascending)", "3. Date (Descending)",
                                "4. Activity Duration (Ascending)", "5. Activity Duration (Descending)",
                                "6. Order by Type of Activity", "7. Distance (Ascending)", "8. Distance (Descending)"};
                        int menuChoice = -1;
                        do {
                            displayMenu(menuOptions, "View Activity in Different Orders");
                            try {
                                menuChoice = getMenuChoice(menuOptions.length);
                                switch (menuChoice) {
                                    case 1:
                                        System.out.println("Calories burned (Descending):");
                                        CaloriesBurnedDesc cbd = new CaloriesBurnedDesc();
                                        Collections.sort(activityList.activityList, cbd);
                                        activityList.display();
                                        break;
                                    case 2:
                                        System.out.println("Date (Ascending):");
                                        // Lambda Function sorts by date in ascending order
                                        Collections.sort(activityList.activityList, (a1, a2) -> a2.getDate().compareTo(a1.getDate()));
                                        activityList.display();
                                        break;
                                    case 3:
                                        System.out.println("Date (Descending):");
                                        // Lambda Function sorts by date in descending order
                                        Collections.sort(activityList.activityList, (a1, a2) -> a1.getDate().compareTo(a2.getDate()));
                                        activityList.display();
                                        break;
                                    case 4:
                                        System.out.println("Activity Duration (Ascending):");
                                        ActivityDurationAsc ada = new ActivityDurationAsc();
                                        Collections.sort(activityList.activityList, ada);
                                        activityList.display();
                                        break;
                                    case 5:
                                        System.out.println("Activity Duration (Descending):");
                                        ActivityDurationDesc adD = new ActivityDurationDesc();
                                        Collections.sort(activityList.activityList, adD);
                                        activityList.display();
                                        break;
                                    case 6:
                                        System.out.println("Type of Activity:");
                                        // Anonymous inner class to sort activities by activity type in ascending order
                                        Collections.sort(activityList.activityList, new Comparator<Activity>() {
                                            @Override
                                            public int compare(Activity a1, Activity a2) {
                                                return a2.getActivityType().compareTo(a1.getActivityType());
                                            }
                                        });
                                        activityList.display();
                                        break;
                                    case 7:
                                        System.out.println("Distance (Ascending):");
                                        Collections.sort(activityList.activityList, (a1, a2) -> (int) (a1.getDistance() - (a2.getDistance())));
                                        activityList.display();
                                        break;
                                    case 8:
                                        System.out.println("Distance (Descending):");
                                        Collections.sort(activityList.activityList, (a1, a2) -> (int) (a2.getDistance() - (a1.getDistance())));
                                        activityList.display();
                                        break;
                                }
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        } while (menuChoice != 0);
                        break;

                    case 2:
                        String[] options = {"0. Exit", "1. All Swimming", "2. All Running", "3. All cycling",
                                "4. Above a minimum distance", "5. Type of energy expended",
                                "6. Above a minimum duration"};
                        int option = -1;
                        do {
                            displayMenu(options, "Activity Tracker");
                            try {
                                option = getMenuChoice(options.length);
                                switch (option) {
                                    case 1:
                                        System.out.println("All Swimming data");
                                        ActivityList.allSwimming(activityList).display();
                                        break;
                                    case 2:
                                        System.out.println("All running data");
                                        ActivityList.allRunning(activityList).display();
                                        break;
                                    case 3:
                                        System.out.println("All cycling data");
                                        ActivityList.allCycling(activityList).display();
                                        break;
                                    case 4:
                                        double minDis;
                                        System.out.println("Enter the minimum distance");
                                        minDis = kb.nextDouble();
                                        ActivityList above = new ActivityList();
                                        for (Activity activity : activityList.activityList) {
                                            if (activity.getDistance() >= minDis) {
                                                above.addActivity(activity);
                                            }
                                        }
                                        above.display();
                                        break;
                                    case 5:
                                        System.out.println("Enter the Type of energy expended");
                                        try {
                                            Intensity intensityInput = Intensity.valueOf(kb.next().toUpperCase());
                                            ActivityList inten = new ActivityList();
                                            for (Activity activity : activityList.activityList) {
                                                // Trim and convert intensity to lowercase for case-insensitive comparison
                                                Intensity activityIntensity = activity.getIntensity();
                                                if (activityIntensity.equals(intensityInput)) {
                                                    inten.addActivity(activity);
                                                }
                                            }
                                            inten.display();
                                        } catch (IllegalArgumentException e) {
                                            System.out.println("Invalid intensity value. Please enter a valid intensity.");
                                        }
                                        break;
                                    case 6:
                                        double minDur;
                                        System.out.println("Enter the minimum duration");
                                        minDur = kb.nextDouble();
                                        ActivityList aboveDur = new ActivityList();
                                        for (Activity activity : activityList.activityList) {
                                            if (activity.getDuration() >= minDur) {
                                                aboveDur.addActivity(activity);
                                            }
                                        }
                                        aboveDur.display();
                                        break;
                                }
                            } catch (RuntimeException e) {
                                throw new RuntimeException(e);
                            }
                        } while (option != 0);
                        break;
                    case 3:
                        String[] opts = {"0. Exit", "1. Average distance Swimming",
                                "2. Average distance Running",
                                "3. Average distance Cycling",
                                "4. Average calories burned"};
                        int op = -1;
                        do {
                            displayMenu(opts, "Activity Tracker");
                            try {
                                op = getMenuChoice(opts.length);
                                switch (op) {
                                    case 1:
                                        System.out.println("Average distance Swimming");
                                        ActivityList swimming = ActivityList.allSwimming(activityList);
                                        System.out.println("Your Average distance for swimming: "+ActivityList.getAvgDistance(swimming));
                                        break;
                                    case 2:
                                        System.out.println("Average distance Running");
                                        ActivityList running = ActivityList.allRunning(activityList);
                                        System.out.println("Your Average distance for running: "+ActivityList.getAvgDistance(running));
                                        break;
                                    case 3:
                                        System.out.println("Average distance Cycling");
                                        ActivityList cycling = ActivityList.allCycling(activityList);
                                        System.out.println("Your Average distance for cycling: "+ActivityList.getAvgDistance(cycling));
                                        break;
                                    case 4:
                                        System.out.println("Average Calories Burned");
                                        System.out.println("Your average Calories Burned are:"+ActivityList.getAvgCaloriesBurned(activityList));
                                        break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid - Please enter a valid option");
                            }
                        } while (op != 0);
                        break;
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }
        } while (choice != 0);
    }

    public static void displayMenu(String[] menuOptions, String menuTitle) {
        System.out.println(menuTitle);
        System.out.println("Please choose from one of the following options:");
        for (String option : menuOptions) {
            System.out.println(option);
        }
    }

    public static int getMenuChoice(int numItems) {
        Scanner keyboard = new Scanner(System.in);
        int choice = keyboard.nextInt();
        while (choice < 0 || choice > numItems) {
            System.out.printf("Enter a valid option (1 - %d)\n", numItems);
            choice = keyboard.nextInt();
        }
        return choice;
    }
}
