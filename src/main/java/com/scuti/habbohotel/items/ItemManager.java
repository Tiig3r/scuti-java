package com.scuti.habbohotel.items;


import com.scuti.Emulator;
import com.scuti.database.Database;
import com.scuti.habbohotel.rooms.Room;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

public class ItemManager {

    private final HashMap<Integer, Item> items;
    private final HashMap<Integer, Furniture> itemsBase;

    public ItemManager() {
        this.items = new HashMap<Integer, Item>();
        this.itemsBase = new HashMap<Integer, Furniture>();
    }

    public void loadItems() {
        long millis = System.currentTimeMillis();
        try(Connection connection = Database.getDB().getConnection()) {
            try(Statement statement = connection.createStatement()) {
                try(ResultSet req = statement.executeQuery("SELECT * FROM items")) {
                    while(req.next()) {
                        this.items.put(req.getInt("id"), new Item(req));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(Emulator.ERROR + "Unable to load items!");
            System.exit(0);
        }
        System.out.println(Emulator.SUCCESS + "Items -> OK! (" + (System.currentTimeMillis() - millis) + " MS)");
    }

    public void loadItemsBase() {
        long millis = System.currentTimeMillis();
        try(Connection connection = Database.getDB().getConnection()) {
            try(Statement statement = connection.createStatement()) {
                try(ResultSet req = statement.executeQuery("SELECT * FROM items_base")) {
                    while(req.next()) {
                        this.itemsBase.put(req.getInt("id"), new Furniture(req));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(Emulator.ERROR + "Unable to load furniture!");
            System.exit(0);
        }
        System.out.println(Emulator.SUCCESS + "Furniture -> OK! (" + (System.currentTimeMillis() - millis) + " MS)");
    }

    public HashMap<Integer, Furniture> getItemsBase() {
        return this.itemsBase;
    }

    public HashMap<Integer, Item> getItems() {
        return this.items;
    }

    public Furniture getItemBase(int id) {
        return this.itemsBase.get(id);
    }
}
