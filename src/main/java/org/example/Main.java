package org.example;


import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        ActivityList activityList = new ActivityList();
        //activityList = ActivityReader.readFromFile("activity_data_1000");
        activityList = ActivityReader.readFromFile("activity_data_100");
        //activityList = ActivityReader.readFromFile("activity_data_100");


        Scanner kb = new Scanner(System.in);
        String[] menuOptions = {"0. Exit", "1. Calories burned(Descending)", "2. Date (Ascending) ",
                "3. Date (Descending)", "4. Activity Duration (Ascending)",
                "5. Activity Duration (Descending)", "6. Order by Type of Activity",
                "7. Distance (Ascending)", "8. Distance (Descending)",
                "9. All Swimming", "10. All Running", "11. All cycling",
                "12. Above a minimum distance", "13. Type of energy expended",
                "14. Above a minimum duration", "15. View statistics on overall performance based on Average distance Swimming"
                ,"16. View statistics on overall performance based on Average distance Running"
                ,"17. View statistics on overall performance based on Average distance Cycling",
                "18. Average calories burned"
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
                        allSwimming(activityList).display();
                        break;
                    case 10:
                        System.out.println("All running data");
                        allRunning(activityList).display();
                        break;
                    case 11:
                        System.out.println("All cycling data");
                        allCycling(activityList).display();

                        break;
                    case 12:
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
                        String intensity;
                        System.out.println("Enter the Type of energy expended");
                        ActivityList intensives = new ActivityList();
                        intensity = kb.next();
                        for(Activity activity:activityList.activityList){
                            if(intensity.equals(activity.getIntensity())){
                                intensives.addActivity(activity);
                            }

                        }
                        if(intensives.size() >= 0) {
                            intensives.display();
                        }
                        else{
                            System.out.println("there is no data with type " + intensity);
                        }

                        break;

                    case 14:
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
                    case 15:
                        System.out.println("Statistics on overall performance based on Average distance Swimming");
                        ActivityList swimming = allSwimming(activityList);

                        System.out.println("Your Average distance for swimming: "+getAvgDistance(swimming));
                        break;
                    case 16:
                        System.out.println("Statistics on overall performance based on Average distance Running");
                        ActivityList running = allRunning(activityList);

                        System.out.println("Your Average distance for running: "+getAvgDistance(running));
                        break;
                    case 17:
                        System.out.println("Statistics on overall performance based on Average distance Cycling");
                        ActivityList cycling = allCycling(activityList);
                        System.out.println("Your Average distance for cycling: "+getAvgDistance(cycling));
                        break;
                    case 18:
                        System.out.println("Average Calories Burned");
                        System.out.println("Your average Calories Burned are:"+getAvgCaloriesBurned(activityList));
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
     * @param menuTitle   a string that is the title of the menu
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

    /**
     * Creates an Activity list of all Activity's with the Activity Type of Cycling from the activityList passed to it
     * @param activityList
     * @return an ActivityList of all the Activity's with the Activity Type of Cycling
     */
    public static ActivityList allCycling(ActivityList activityList) {
        //create a new ActivityList this will hold all the Activity with the type of cycling
        ActivityList cycling = new ActivityList();
        //iterate through the activityList
        for (Activity activity : activityList.activityList) {
            //if its of type Cycling
            if (activity.getActivityType() == ActivityType.CYCLING) {
                //add it to the new ActivityList
                cycling.addActivity(activity);
            }
        }
            return cycling;

    }
    /**
     * Creates an Activity list of all Activity's with the Activity Type of running from the activityList passed to it
     * @param activityList
     * @return an ActivityList of all the Activity's with the Activity Type of running
     */
    public static ActivityList allRunning(ActivityList activityList){
        ActivityList running = new ActivityList();
        for (Activity activity : activityList.activityList) {
            if (activity.getActivityType() == ActivityType.RUNNING) {
                running.addActivity(activity);
            }
        }
      return  running;
    }

    /**
     * Creates an Activity list of all Activity's with the Activity Type of swimming from the activityList passed to it
     * @param activityList
     * @return an ActivityList of all the Activity's with the Activity Type of swimming
     */
    public static ActivityList allSwimming(ActivityList activityList){
        ActivityList swimming = new ActivityList();
        for (Activity activity : activityList.activityList) {
            if (activity.getActivityType() == ActivityType.SWIMMING) {
                swimming.addActivity(activity);
            }
        }
         return swimming;
    }

    /**
     * gets the average distance for all activity's in an ActivityList passed to it
     * @param list
     * @return a double the average distance of the activies in the list
     */
    public static double getAvgDistance(ActivityList list){
        double totalDistance =0;
        int count =0;
        for (Activity activity : list.activityList) {
            totalDistance += activity.getDistance();
            count ++;
        }
        return totalDistance/count;

    }

    /**
     * gets the average Calories Burned for all activity's in an ActivityList passed to it
     * @param list
     * @return a double the average Calories Burned of the activies in the list
     */
    public static double getAvgCaloriesBurned(ActivityList list){
        double totalCaloriesBurned =0;
        int count =0;
        for (Activity activity : list.activityList) {
            totalCaloriesBurned += activity.getCaloriesBurned();
            count ++;
        }
        return totalCaloriesBurned/count;

    }


}