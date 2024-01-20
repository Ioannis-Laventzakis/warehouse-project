package com.dci.java.data.stock;

import java.util.Date;

public class Item {
    private String state;
    private String category;
    private Date dateOfStock;
    private int warehouse;

    public Item(String state, String category, Date dateOfStock, int warehouse) {
        this.state = state;
        this.category = category;
        this.dateOfStock = dateOfStock;
        this.warehouse = warehouse;
    }

    public String getState() {
        return state;
    }

    public String getCategory() {
        return category;
    }

    public Date getDateOfStock() {
        return dateOfStock;
    }

    public int getWarehouse() {
        return warehouse;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDateOfStock(Date dateOfStock) {
        this.dateOfStock = dateOfStock;
    }

    public void setWarehouse(int warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public String toString() {
        return "Item{" +
                "state=" + state +
                ", category=" + category;
    }
}