package com.scuti.habbohotel.items;

import com.scuti.habbohotel.users.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Item {
    private final int id;
    private int userId;
    private int roomId;
    private final int itemBaseId;
    private String wallPos;
    private int x;
    private int y;
    private int z;
    private int rotation;
    private String extraData;
    //private String wiredData;
    //private String limitedData;
    //private int guildId;

    public Item(ResultSet set) throws SQLException {
        this.id = set.getInt("id");
        this.userId = set.getInt("user_id");
        this.roomId = set.getInt("room_id");
        this.itemBaseId = set.getInt("item_id");
        this.wallPos = set.getString("wall_pos");
        this.x = set.getInt("x");
        this.y = set.getInt("y");
        this.z = set.getInt("z");
        this.rotation = set.getInt("rot");
        this.extraData = set.getString("extra_data");
    }

    public int getId() {
        return this.id;
    }

    public int getOwner() {
        return this.userId;
    }

    public void setOwner(User newOwner) {
        this.userId = newOwner.getId();
    }

    public int getRoom() {
        return this.roomId;
    }

    public int getItemBaseId() {
        return this.itemBaseId;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return this.z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public void setRoomId(int id) {
        this.roomId = id;
    }

    public void setWallPos(String pos) {
        this.wallPos = pos;
    }

    public int getRotation() {
        return this.rotation;
    }

    public void rotate() {
        //TODO: create the method which turns an item
    }
}
