package com.scuti.habbohotel.items;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Furniture {
    private int id;
    // private int spriteId;
    private String publicName;
    private String itemName;
    private int type; //TODO: create a class for item types.
    private int width;
    private int length;
    private int stackHeight;
    private boolean allowStack;
    private boolean allowSit;
    private boolean allowLay;
    private boolean allowWalk;
    private boolean allowGift;
    private boolean allowTrade;
    private boolean allowRecycle;
    // private boolean allowMarketPlaceSell;
    private boolean allowInventoryStack;
    private String interactionType;
    private int InteractionModesCount;
    //private String vendingIds;
    private String multiHeight;
    private String customParams;
    private int effectIdMale;
    private int getEffectIdFemale;
    // private String clothingOnWalk;

    public Furniture(ResultSet set) throws SQLException {
        this.id = set.getInt("id");
        this.publicName = set.getString("public_name");
        this.itemName = set.getString("item_name");
        this.width = set.getInt("width");
        this.length = set.getInt("length");
    }

    public int getId() {
        return this.id;
    }

    public String getPublicName() {
        return this.publicName;
    }

    public String getItemName() {
        return this.itemName;
    }

    public int getWidth() {
        return this.width;
    }

    public int getLength() {
        return this.length;
    }

}
