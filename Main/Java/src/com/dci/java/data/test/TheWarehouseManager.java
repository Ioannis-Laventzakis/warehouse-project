package com.dci.java.data.test;

import com.dci.java.data.personnel.Employee;
import com.dci.java.data.personnel.User;
import com.dci.java.data.stock.Item;



import java.util.Scanner;
import java.util.Date;



public class TheWarehouseManager {

    // some more attributes
    private static boolean IS_EMPLOYEE = false;
    private static Employee employee;


    public static void main(String[] args) {

        // Scanner instance
        Scanner scanner = new Scanner(System.in);

        // First Case 'GUEST USER'
        // ask for the name
        /*System.out.println("Hello and welcome to our Warehouse App.\n" +
                "To continue we please ask you to enter your username.\n" +
                "(keep in mind to pay attention to your spelling)");
        String name = scanner.nextLine();

        checkIfUserIsEmployee(name);



        // greet message for guest user
        greetUser(name);



        // ask to verify the name again
        System.out.println("---------------------------------------------------------------\n" +
                "---------------------------------------------------------------");
        System.out.println("To verify that you are a human, please enter your name again.\n" +
                "(keep in mind to pay attention to your spelling)");
        String username = scanner.nextLine();

        User guest = new User(name);
        if (guest.isNamed(username)) {
            System.out.println("Thank you for verifying that you are human.");
            System.out.println("---------------------------------------------------------------\n" +
                    "---------------------------------------------------------------");
        } else {
            System.out.println("I am sorry to inform you that you are not a human. \n" +
                    "01000111 01101111 01101111 01100100 01100010 01111001 01100101");  // Goodbye in Binary Code much wow
                    System.exit(0);

        // bye message because the user cannot purchase anything
            System.out.println("Since you are a guest user, we cannot let you use any of our services.\n" +
                    "We hope you enjoyed your stay :)");
            quit(name);

        }*/


        //--------------------------------------------------------------------------------------------------------------


        // Second Case 'EMPLOYEE USER'
        // ask for the name
        System.out.println("Hello and welcome to our Warehouse App.\n" +
                "To continue we please ask you to enter your username.\n" +
                "(keep in mind to pay attention to your spelling)");
        String name = scanner.nextLine();

        checkIfUserIsEmployee(name);


        // greet message for employee user
        greetUser(name);


        // ask to verify the name again
        System.out.println("---------------------------------------------------------------\n" +
                "---------------------------------------------------------------");
        System.out.println("To verify that you are a human, please enter your name again.\n" +
                "(keep in mind to pay attention to your spelling)");
        String username = scanner.nextLine();

        // ask to verify the password again
        System.out.println("Please enter your password to continue:");
        String password = scanner.nextLine();

        // Check if employee is a valid user
        if (UserRepository.isUserValid(username, password)) {
            System.out.println("Thank you for letting us know that you are human.");
        } else {
            System.out.println("I am sorry to inform you that you are not a human. \n" +
                    "01000111 01101111 01101111 01100100 01100010 01111001 01100101");
            System.exit(0); // if not valid, end program
        }


        // show how many warehouses we have
        System.out.println("These are our current Warehouses: " + WarehouseRepository.getWarehouses());


        // Show list of inventory
        System.out.println("To make your life easier, we will now show you a list of all our items that are currently available.");
        System.out.println("Our overall item inventory includes :" + WarehouseRepository.getAllItems());


        // Ask Employee if they want to add a new item to the inventory
        System.out.println("If you are not satisfied with our current inventory we also give you the option to add a new Item to it.\n" +
                "Do you want to add a new Item? Please answer with yes or no");
        String answer = scanner.nextLine();

        if (answer.equals("yes")) {
            System.out.println("Please enter the state of the Item (brand new, used, ..): ");
            String state = scanner.nextLine();
            System.out.println("Please enter the category of the Item (TV, Fruit, ,,,): ");
            String category = scanner.nextLine();
            System.out.println("Please enter the warehouse number you want to add the item to (1-5): ");
            int number = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            // new list with the included Item
            Item item = new Item(state, category, new Date(), number);
            System.out.println("The new Item has been added: " + item);

            //adds the new Item
            System.out.println("Do you want to add this Item to your order? \n" +
                    "Please answer with yes or no");
            String answerTwo = scanner.nextLine();
            if (answerTwo.equals("yes")) {
                System.out.println("Give us the amount (in numbers) you want to purchase: ");
                int amount = scanner.nextInt();
                scanner.nextLine();
                employee.order(item.getCategory(), amount);
            }

        } else {
            System.out.println("That is good to hear.");
        }

        // Ask user if he wants to search for a specify item
        System.out.println("We also offer the option that you can search for an Item in our system." +
                "Do you want to search for an item? \n" +
                "Please answer with yes or no");
        String answerThird = scanner.nextLine();


        if (answerThird.equals("yes")) {
            System.out.println("Please tell us the name of the category you'd like to search for: ");
            String category = scanner.nextLine();

            System.out.println(WarehouseRepository.getItemsByCategory(category));

        } else {
            System.out.println("Seems like you are all set");
        }

        System.out.println("---------------------------------------------------------------\n" +
                "---------------------------------------------------------------");
        // show the list again to show the items to order
        System.out.println("Now we will show you our inventory a second time to make your shopping experience easier: ");
        System.out.println("Our overall item inventory includes :" + WarehouseRepository.getAllItems());


        //Ask if the employee wants to order anything from it
        System.out.println("Now after seeing our amazing inventory, do you want to order another item? \n" +
                "Please answer with yes or no");
        String answerFourth = scanner.nextLine();

        if (answerFourth.equals("yes")) {
            System.out.println("Tell us the name of the item you want to purchase: ");
            String itemName = scanner.nextLine();

            System.out.println("Give us the amount (in numbers) you want to purchase: ");
            int itemAmount = scanner.nextInt();
            employee.order(itemName, itemAmount);
        } else {
            System.out.println("Thank you for being with us.");
        }
        quit(name);
        scanner.close();


        // if you want to be really fancy, add a loop to add items
    }


    // uses the method from UserRepo to simplify other methods
    // every method you create in here should be static (or work with instance of warehousemanager)
    public static void checkIfUserIsEmployee(String name) {
        if (UserRepository.isUserEmployee(name)) {
            employee = UserRepository.getEmployee(name);
            IS_EMPLOYEE = true;
        }
    }

    // updated greet method
    public static void greetUser(String name) {
        if (IS_EMPLOYEE) {
            employee.greet();
        } else {
            new User(name).greet();
        }
    }

    // updated bye method
    public static void quit(String name) {
        if (IS_EMPLOYEE) {
            employee.bye();
        } else {
            new User(name).bye();
        }
    }

}