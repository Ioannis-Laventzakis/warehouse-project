package com.dci.java.data.stock;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private int id;
    private List<Item> stock;

    public Warehouse(int id) {
        this.id = id;
        this.stock = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public List<Item> getStock() {
        return stock;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStock(List<Item> stock) {
        this.stock = stock;
    }

    public int occupancy() {
        return stock.size();
    }

    public void addItem(Item item) {
        stock.add(item);
    }

    public List<Item> search(String searchTerm) {
        List<Item> matchingItems = new ArrayList<>();
        for (Item item : stock) {
            if (item.getCategory().toLowerCase().equals(searchTerm.toLowerCase())){
                matchingItems.add(item);
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