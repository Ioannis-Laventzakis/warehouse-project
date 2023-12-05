package com.dci.java.data.personnel;

import java.util.List;
import java.util.ArrayList;

public class Employee extends User {
    //Employee extends User, takes in attributes and methods AS WELL as two new attributes


    // ATTRIBUTES
    private String password;
    private List<Employee> headOf;
    private List<String> actionsTaken;


    // CONSTRUCTOR -> overwritten with included password
    //The argument headOf is a list of employee and is optional.
    // If there is such argument, the constructor should save it in the headOf property as a list of Employee objects
    // just delete the List?
    public Employee(String userName, String password, /*List<Employee> headOf*/Object o) {
        super(userName);
        this.password = password;
        this.headOf = new ArrayList<>();        // Empty list by default
        this.actionsTaken = new ArrayList<>();  // EMpty list by default -> only there to create summarys
    }


    // GETTER
    public String getPassword() {
        return password;
    }

    public List<Employee> getHeadOf() {
        return headOf;
    }


    // SETTER
    public void setPassword(String password) {
        this.password = password;
    }

    public void setHeadOf(List<Employee> headOf) {
        this.headOf = headOf;
    }


    // METHODS
    // authenticate (overwrite) -> compares input password with this.password
    public boolean authenticate(String inputPassword) {
        return password.equals(inputPassword);
    }


    // order method ->  print the name of the item and amount ordered by the user
    // includes the new action in the actionsTaken Array to print it at the end
    public void order(String item, int amount) {
        String action = "Your order was placed. Item: " + item + ", Amount: " + amount;
        actionsTaken.add(action);
        System.out.println(action);
    }


    // greet method -> different from user
    public void greet() {
        System.out.println("Hello, " + name + "!\n" +
                "If you experience a problem with the system,\n" +
                "please contact technical support.");
    }


    // bye method -> call the parent method + print list of actions
    public void bye() {
        super.bye();        // calls the parent method to write thank you message

        System.out.println("Here is the summary of all your actions: \n");  // message before summary
        for (String action : actionsTaken) {        // iterates through every action in the actionTaken Array and prints it
            System.out.println(action);
        }
    }
}