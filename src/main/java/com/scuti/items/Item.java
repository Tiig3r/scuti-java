package com.scuti.items;

import com.scuti.rooms.Room;
import com.scuti.users.User;

import java.sql.ResultSet;

public class Item {
    private int id;
    private int ownerId;
    private int furnitureId;
    private int roomId;
    private int x;
    private int y;
    private int z;
    private int rotation;

    public Item(ResultSet set) {
        // TODO: create database table corresponding to this class
    }

    public Item(int id, int ownerId, int furnitureId) {
        this.id = id;
        this.ownerId = ownerId;
        this.furnitureId = furnitureId;
    }

    public int getId() {
        return this.id;
    }

    public int getOwner() {
        return this.ownerId;
    }

    public void setOwner(User newOwner) {
        this.ownerId = newOwner.getId();
    }

    public int getRoom() {
        return this.roomId;
    }

    public int getFurni() {
        return this.furnitureId;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getZ() {
        return this.z;
    }
}
