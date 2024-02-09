package com.dci.java.data.personnel;

public class User {
    protected String name = "Anonymous";
    private boolean isAuthenticated = false;

    public User(String userName) {
        this.name = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean authenticate(String password){
        return "password".equals(password);
    }

    public boolean isNamed(String inputName){
        return name.equals(inputName);
    }

    public void greet(){
        System.out.println("Hello, " + name + "!\n" +
                "Welcome to our Warehouse Database.\n" +
                "If you don't find what you are looking for,\n" +
                "please ask one of our staff members to assist you.");
    }

    public void bye(){
        System.out.println("Thank you " + name + "! \n" +
                "See you again.\n");
    }
}