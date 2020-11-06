package com.scuti.users;

import com.scuti.Emulator;
import com.scuti.catalog.CatalogItem;
import com.scuti.gameclients.GameClient;
import com.scuti.items.Item;
import com.scuti.items.ItemManager;
import com.scuti.rooms.Room;
import com.scuti.rooms.RoomTile;
import org.eclipse.jetty.websocket.api.Session;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private final int id;
    private String username;
    private int credits;
    private int pixels;
    private int diamonds;
    private final HashMap<Integer, Item> inventory;
    private Room room;
    private int x;
    private int y;
    private int z;
    private String sso;
    private Session client;

    public User(ResultSet set) throws SQLException {
        // TODO: create a load function
        this.id = set.getInt("id");
        this.username = set.getString("username");
        this.credits = set.getInt("credits");
        this.pixels = set.getInt("pixels");
        this.diamonds = set.getInt("diamonds");
        this.inventory = new HashMap<Integer, Item>();
        this.setInventory();
    }

    public void setClient(Session client) {
        this.client = client;
    }

    public Session getClient() {
        return this.client;
    }

    public boolean canBuy(CatalogItem catalogItem) {
        int credits = catalogItem.getCostCredits();
        int pixels = catalogItem.getCostPixels();
        int diamonds = catalogItem.getCostDiamonds();
        return this.credits >= credits && this.pixels >= pixels && this.diamonds >= diamonds;
    }

    public void purchase(CatalogItem catalogItem) {
        if(catalogItem.isPurchasable()) {
            if(this.canBuy(catalogItem)) {
                Item item = new Item(Emulator.scuti().getItemManager().getItems().size() + 1, this.id, catalogItem.getId());
                this.addCredits(-catalogItem.getCostCredits());
                this.addPixels(-catalogItem.getCostPixels());
                this.addDiamonds(-catalogItem.getCostDiamonds());
            } else {
                // this.client.sendMessage(new BubbleAlertComposer("/smthg.png", "AA", "AA"));
            }
        } else {
            // this.client.sendMessage(new BubbleAlertComposer("/smthg.png", "AA", "AA"));
        }
    }

    public void setInventory() {
        for(Item item: Emulator.scuti().getItemManager().getItems().values()) {
            if(item.getOwner() == this.id) {
                this.inventory.put(item.getId(), item);
            }
        }
    }

    public void giveGift(User user, Item furni) {
        this.deleteItemFromInventory(furni);
        user.addItemToInventory(furni);
    }

    public void addItemToInventory(Item furni) {
        this.inventory.put(furni.getId(), furni);
    }

    public void deleteItemFromInventory(Item item) {
        this.inventory.remove(item.getId());
    }

    public boolean checkSso() {
        return false;
    }

    public String getSso() {
        return this.sso;
    }

    public HashMap<Integer, Item> getInventory() {
        return this.inventory;
    }

    public Room getCurrentRoom() {
        return this.room;
    }

    public void goToRoom(Room room) {
        this.room = room;
        room.getUsers().put(this.getId(), this);
    }

    public int getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String newUsername) {
        this.username = newUsername;
    }

    public int getCredits() {
        return this.credits;
    }

    public void addCredits(int x) {
        this.credits = this.credits + x;
    }

    public int getPixels() {
        return this.pixels;
    }

    public void addPixels(int x) {
        this.pixels = this.pixels + x;
    }

    public int getDiamonds() {
        return this.diamonds;
    }

    public void addDiamonds(int x) {
        this.diamonds = this.diamonds + x;
    }

    public int getX() { return this.x; }

    public int getY() { return this.y; }

    public int getZ() { return this.z; }

    //TODO: pathfinder... lol :c
    public void goToTile(RoomTile tile) {

    }
}
