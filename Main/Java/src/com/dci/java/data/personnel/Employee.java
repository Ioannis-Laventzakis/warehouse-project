package com.dci.java.data.personnel;

import java.util.List;
import java.util.ArrayList;

// Employee class extends User class
public class Employee extends User {
    // Employee's password
    private String password;
    // List of employees that this employee is head of
    private List<Employee> headOf;
    // List of actions taken by this employee
    private List<String> actionsTaken;

    // Constructor
    public Employee(String userName, String password) {
        super(userName);
        this.password = password;
        this.headOf = new ArrayList<>();
        this.actionsTaken = new ArrayList<>();
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Getter for headOf
    public List<Employee> getHeadOf() {
        return headOf;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }

    // Setter for headOf
    public void setHeadOf(List<Employee> headOf) {
        this.headOf = headOf;
    }

    // Method to authenticate the employee
    public boolean authenticate(String inputPassword) {
        return password.equals(inputPassword);
    }

    // Method to place an order
    public void order(String item, int amount) {
        String action = "Your order was placed. Item: " + item + ", Amount: " + amount;
        actionsTaken.add(action);
        System.out.println(action);
    }

    // Method to greet the employee
    public void greet() {
        System.out.println("Hello, " + name + "!\n" +
                "If you experience a problem with the system,\n" +
                "please contact technical support.");
    }

    // Method to say goodbye to the employee
    public void bye() {
        super.bye();
        System.out.println("Here is the summary of all your actions: \n");
        for (String action : actionsTaken) {
            System.out.println(action);
        }
    }
}