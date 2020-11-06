package com.scuti.items;


import java.util.HashMap;

public class ItemManager {

    private final HashMap<Integer, Item> items;
    private final HashMap<Integer, Furniture> itemsBase;

    public ItemManager() {
        this.items = new HashMap<Integer, Item>();
        this.itemsBase = new HashMap<Integer, Furniture>();
    }

    public void loadItems() {

    }

    public void loadItemsBase() {

    }

    public HashMap<Integer, Furniture> getItemsBase() {
        return this.itemsBase;
    }

    public HashMap<Integer, Item> getItems() {
        return this.items;
    }
}
