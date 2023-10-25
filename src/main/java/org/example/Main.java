package org.example;


import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        ActivityList activityList = new ActivityList();
        activityList = ActivityReader.readFromFile("activity_data_10");
       //activityList = ActivityReader.readFromFile("activity_data_50");
        //activityList = ActivityReader.readFromFile("activity_data_100");


        Scanner kb = new Scanner(System.in);
        String[] menuOptions = {"0. Exit", "1. Calories burned(Descending)", "2. Date (Ascending) ",
                "3. Date (Descending)", "4. Activity Duration (Ascending)",
                "5. Activity Duration (Descending)", "6. Type of Activity",
                "7. Distance (Ascending)", "8. Distance (Descending)",
                "9. All Swimming", "10. All Running", "11. All cycling",
                "12. Above a minimum distance", "13. Type of energy expended", "14. Above a minimum duration"
        };

        int menuChoice = -1;
        do {
            displayMenu(menuOptions, "Activity Tracker");
            try {
                menuChoice = getMenuChoice(menuOptions.length);
                switch (menuChoice) {
                    case 1:
                        System.out.println("Calories burned(Descending):");
                        CaloriesBurnedDesc cbd = new CaloriesBurnedDesc();
                        Collections.sort(activityList.activityList, cbd);
                        activityList.display();
                        break;
                    case 2:
                        System.out.println("Date (Ascending):");
                        // Lambda Function
                        Collections.sort(activityList.activityList, (a1, a2) -> a2.getDate().compareTo(a1.getDate()));
                        activityList.display();
                        break;

                    case 3:
                        System.out.println("Date (Descending):");
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
                        // Anonymous inner class to sort activities by activity type in asc order
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
                    case 9:
                        System.out.println("All Swimming data");
                        ActivityList swimming = new ActivityList();
                        for (Activity activity : activityList.activityList) {
                            if (activity.getActivityType() == ActivityType.SWIMMING) {
                                swimming.addActivity(activity);
                            }
                        }
                        swimming.display();
                        break;
                    case 10:
                        System.out.println("All running data");
                        ActivityList running = new ActivityList();
                        for (Activity activity : activityList.activityList) {
                            if (activity.getActivityType() == ActivityType.RUNNING) {
                                running.addActivity(activity);
                            }
                        }
                        running.display();
                        break;
                    case 11:
                        System.out.println("All cycling data");
                        ActivityList cycling = new ActivityList();
                        for (Activity activity : activityList.activityList) {
                            if (activity.getActivityType() == ActivityType.CYCLING) {
                                cycling.addActivity(activity);
                            }
                        }
                        cycling.display();
                        break;
                    case 12:
                        // Scanner in = new Scanner(System.in);
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

                    case 13:
                        System.out.println("Type of energy expended");


                        break;

                    case 14:
                        // Scanner in = new Scanner(System.in);
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
            } catch (InputMismatchException e) {
                System.out.println("Invalid - Please enter a valid option");
            }
        } while (menuChoice != 0);


    }


    /**
     * <b>displayMenu</b>
     * <p>
     * displays the menu on the console and will ask the user to choose an
     * option</p>
     *
     * @param menuOptions an array of strings of menu options to be displayed
     * @param menuTitle a string that is the title of the menu
     */
    public static void displayMenu(String[] menuOptions, String menuTitle) {
        //displays the title of the menu
        System.out.println(menuTitle);
        //ask the user choose an option
        System.out.println("Please choose from one of the following options:");
        //loops through the menuOptionsdisplaying each one to the user
        for (String option : menuOptions) {
            System.out.println(option);
        }
    }

    /**
     * <b>getMenuChoice</b>
     * <p>
     * asks the user to enter a menu choice and will returns it if the choice
     * entered is not valid the user will be asked again</p>
     *
     * @param numItems the number of menu items available to choose from
     * @return the menu choice entered by the user
     */
    public static int getMenuChoice(int numItems) {

        Scanner keyboard = new Scanner(System.in);
        //reads the user choice from the console will be stored in the variable choice
        int choice = keyboard.nextInt();
        while (choice < 0 || choice > numItems) {
            //if invalid choice entered will ask user to choose again
            System.out.printf("Enter a valid option (1 - %d)\n", numItems);
            choice = keyboard.nextInt();
        }
        return choice;
    }

}