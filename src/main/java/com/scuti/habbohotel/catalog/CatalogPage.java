package com.scuti.habbohotel.catalog;

import com.scuti.Emulator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class CatalogPage {
    private final int id;
    private final String caption;
    private final int minRank;
    private final boolean visible;
    private final HashMap<Integer, CatalogItem> items;

    public CatalogPage(ResultSet req) throws SQLException {
        this.id = req.getInt("id");
        this.caption = req.getString("caption");
        this.minRank = req.getInt("min_rank");
        this.visible = req.getBoolean("visible");
        this.items = new HashMap<Integer, CatalogItem>();
    }

    public void loadItems() {
        for(CatalogItem catalogItem: Emulator.scuti().getCatalogManager().getCatalogItems().values()) {
            if(catalogItem.getPageId() == this.id) {
                this.items.put(catalogItem.getOrderNumber(), catalogItem);
                // TODO: Sort items HashMap by keys (method: sort items)
                this.sortItems();
            }
        }
    }

    public void sortItems() {

    }

    public HashMap<Integer, CatalogItem> getItems() {
        return this.items;
    }

    public int getId() {
        return id;
    }

    public String getCaption() {
        return caption;
    }

    public int getMinRank() {
        return minRank;
    }

    public boolean isVisible() {
        return visible;
    }
}
