package com.dci.java.data.personnel;

import java.util.List;
import java.util.ArrayList;

public class Employee extends User {
    private String password;
    private List<Employee> headOf;
    private List<String> actionsTaken;

    public Employee(String userName, String password) {
        super(userName);
        this.password = password;
        this.headOf = new ArrayList<>();
        this.actionsTaken = new ArrayList<>();
    }

    public String getPassword() {
        return password;
    }

    public List<Employee> getHeadOf() {
        return headOf;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHeadOf(List<Employee> headOf) {
        this.headOf = headOf;
    }

    public boolean authenticate(String inputPassword) {
        return password.equals(inputPassword);
    }

    public void order(String item, int amount) {
        String action = "Your order was placed. Item: " + item + ", Amount: " + amount;
        actionsTaken.add(action);
        System.out.println(action);
    }

    public void greet() {
        System.out.println("Hello, " + name + "!\n" +
                "If you experience a problem with the system,\n" +
                "please contact technical support.");
    }

    public void bye() {
        super.bye();
        System.out.println("Here is the summary of all your actions: \n");
        for (String action : actionsTaken) {
            System.out.println(action);
        }
    }
}