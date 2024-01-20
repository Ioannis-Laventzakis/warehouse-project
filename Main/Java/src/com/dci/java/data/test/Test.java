package com.dci.java.data.test;

import com.dci.java.data.personnel.Employee;
import com.dci.java.data.personnel.User;
import com.dci.java.data.stock.Item;
import com.dci.java.data.stock.Warehouse;
import com.dci.java.data.WarehouseRepository;

import java.util.Date;

public class Test {
    public static void main(String[] args) {

        // STOCK TEST
        Warehouse one = new Warehouse(1);
        Warehouse two = new Warehouse(2);

        // add items to the warehouses
        one.addItem(new Item("brand new", "keyboard",new Date(),1));
        one.addItem(new Item("bused", "mouse",new Date(),1));

        System.out.println("should result 1 : "); // should result 1
        one.occupancy();
        System.out.println("should result 0 : "); // should result 0
        two.occupancy();
        // Example Test works
        System.out.println("-----------------------------"); // should result 0


        System.out.println(one.search("keyboard")); // should result 1
        System.out.println(one.search("KeYbOaRd"));
        // Search method works

        System.out.println("-----------------------------");


        // PERSONNEL TEST
        // USER
        User userOne = new User("Michail"); // create a user
        User userTwo = new User("Jackson");

        System.out.println(userOne.authenticate("lalalala")); // should result false
        System.out.println(userTwo.isNamed("Jackson"));
        System.out.println(userOne.isNamed("hello"));
        System.out.println("-----------------------------");
        userOne.greet();
        System.out.println("-----------------------------");
        userTwo.bye();


        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
        // USER Class works


        // EMPLOYEE
        Employee employeeOne = new Employee("Bisasam","BisaBisa");
        Employee employeeTwo = new Employee("Pikachu","PikaPika");



        System.out.println(employeeOne.authenticate("BisaBisa"));
        System.out.println(employeeOne.authenticate("bisabisa")); // case-sensitive? it should print false
        //authentication works

        employeeTwo.order("Apple",5); // should print "Your order was placed. Item: Apple, Amount: 5"
        employeeTwo.order("Banana",2);
        employeeTwo.order("Orange",4);
        //order method works

        employeeOne.greet(); // should print "Hello, Bisasam!
        System.out.println("-----------------------------");
        employeeTwo.bye();

        // Loading the data from the JSON files
        System.out.println("Loading warehouse data:");
        for (Warehouse warehouse : WarehouseRepository.WAREHOUSE_LIST) {
            System.out.println(warehouse.toString());
        }
    }
}