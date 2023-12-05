package com.dci.java.data.stock;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {

    // ATTRIBUTES
    private int id;
    private List<Item> stock;





    // CONSTRUCTOR
    public Warehouse(int id/*, List<String> stock*/) {
        this.id = id;
        this.stock = new ArrayList<>(); // "it must simply initialize the stock attribute as an empty list"
        // Arraylist ensures that each Warehouse object starts with an empty stock
    }





    // GETTER
    public int getId() {
        return id;
    }

    public List<Item> getStock() {
        return stock;
    }






    // SETTER
    public void setId(int id) {
        this.id = id;
    }

    public void setStock(List<Item> stock) {
        this.stock = stock;
    }






    // METHODS
    // Warehouse method -> warehouseID = none -> method to display just the ID?


    // occupancy method -> return an integer representing the number of items in stock
    // .size will give us an int of the size of the array size=how many items are in the array
    public void occupancy() {
        System.out.println("We have " + stock.size() + " Item/s in Stock.");
    }


    // addItem method -> takes an instance of Item as an argument
    public void addItem(Item item) {
        stock.add(item);
    }


    // search method -> return the list of matching items
    public List<Item> search(String searchTerm) {
        List<Item> matchingItems = new ArrayList<>();     // new Array to store the matching items

        for (Item item : stock) {         // iterates through all items in stock
            if (item.getCategory().toLowerCase().equals(searchTerm.toLowerCase())){   // compares the items
                matchingItems.add(item);           // adds found item to new array
            }
        }
        return matchingItems;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", stock=" + stock +
                '}';
    }
}