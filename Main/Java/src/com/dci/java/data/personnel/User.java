package com.dci.java.data.personnel;

public class User {

    // ATTRIBUTES
    protected String name = "Anonymous";        // If user provides an empty string as name, name should be "Anonymous"
    private boolean isAuthenticated = false;    // will not change for the standard users/ is a placeholder






    // CONSTRUCTOR -> takes argument named userName & stores in name
    public User(String userName) {
        this.name = userName;
    }




    // is better to have get and set to not work with the protected attribute directly
    // GETTER
    public String getName() {
        return name;
    }





    // SETTER
    public void setName(String name) {
        this.name = name;
    }






    // METHODS
    // authenticate with String password-> always returns false
    // just a placeholder
    public boolean authenticate(String password){
        return false;
    }


    // isNamed -> return true if the name passed to the method equals the this.name property
    public boolean isNamed(String inputName){
        return name.equals(inputName);
    }



    // Greeting method for all users
    public void greet(){
        System.out.println("Hello, " + name + "!\n" +
                "Welcome to our Warehouse Database.\n" +
                "If you don't find what you are looking for,\n" +
                "please ask one of our staff members to assist you.");
    }



    //bye method for all users
    //include method that is appears after user wants to see summary?
    public void bye(){
        System.out.println("Thank you " + name + "! \n" +
                "See you again.\n");
    }
}