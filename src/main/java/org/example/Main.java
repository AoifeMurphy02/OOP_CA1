package org.example;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        ActivityList activityList = new ActivityList();
        activityList = ActivityReader.readFromFile("activity_data_50");
        activityList.display();


        Scanner kb = new Scanner(System.in);
        String[] menuOptions = {"0. Exit", "1. Calories burned(Descending)", "2. Date (Ascending) ",
                "3. Date (Descending)", "4. Activity Duration (Ascending)",
                "5. Activity Duration (Descending)", "6. Type of Activity", "7. Distance (Ascending)", "8. Distance (Descending)"
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