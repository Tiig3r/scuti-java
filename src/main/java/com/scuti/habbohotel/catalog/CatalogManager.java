package com.scuti.habbohotel.catalog;

import com.scuti.Emulator;
import com.scuti.database.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class CatalogManager {
    private final HashMap<Integer, CatalogPage> pages;
    private final HashMap<Integer, CatalogCategory> categories;
    private final HashMap<Integer, CatalogItem> catalogItems;

    public CatalogManager() {
        this.pages = new HashMap<Integer, CatalogPage>();
        this.categories = new HashMap<Integer, CatalogCategory>();
        this.catalogItems = new HashMap<Integer, CatalogItem>();
    }

    public HashMap<Integer, CatalogPage> getPages() {
        return this.pages;
    }

    public HashMap<Integer, CatalogCategory> getCategories() {
        return this.categories;
    }

    public HashMap<Integer, CatalogItem> getCatalogItems() {
        return this.catalogItems;
    }

    /*public void loadItems() throws SQLException {
        System.out.println(App.LOADING + "Loading catalog items...");
        try(Connection connection = Database.getDB().getConnection()) {
            try(Statement statement = connection.createStatement()) {
                try(ResultSet req = statement.executeQuery("SELECT * FROM catalog_items")) {
                    while(req.next()) {
                        // TODO: create item class + database table corresponding!
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(App.ERROR + "Unable to load catalog items!");
        }
    }*/

    public void loadPages() throws SQLException {
        long millis = System.currentTimeMillis();
        try(Connection connection = Database.getDB().getConnection()) {
            try(Statement statement = connection.createStatement()) {
                try(ResultSet req = statement.executeQuery("SELECT * FROM catalog_pages")) {
                    while(req.next()) {
                        this.pages.put(req.getInt("id"), new CatalogPage(req));
                        System.out.println(Emulator.SUCCESS + "Catalog pages -> OK! (" + (System.currentTimeMillis() - millis) + " MS)");
                    }
                }
            }
        } catch(Exception e) {
            System.out.println(Emulator.ERROR + "Unable to load catalog pages!");
        }
    }

    public void loadCategories() {

    }
}
