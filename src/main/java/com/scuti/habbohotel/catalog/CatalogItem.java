package com.scuti.habbohotel.catalog;

import java.sql.ResultSet;

public class CatalogItem {
    private int id;
    private int pageId;
    private int furnitureId;
    private int orderNumber;
    private int costCredits;
    private int costPixels;
    private int costDiamonds;
    private int amount;
    private boolean purchasable;

    public CatalogItem(ResultSet set) {
        // TODO: create database table corresponding to this class
    }

    public int getId() {
        return this.id;
    }

    public boolean isPurchasable() {
        return this.purchasable;
    }

    public int getPageId() {
        return this.pageId;
    }

    public int getFurnitureIdId() {
        return this.furnitureId;
    }

    public int getOrderNumber() {
        return this.orderNumber;
    }

    public int getCostCredits() {
        return this.costCredits;
    }

    public int getCostPixels() {
        return this.costPixels;
    }

    public int getCostDiamonds() {
        return this.costDiamonds;
    }

    public int getAmount() {
        return this.amount;
    }
}
