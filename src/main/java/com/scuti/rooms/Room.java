package com.scuti.rooms;

import com.scuti.users.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Room {
    /** TODO: HashMap arrays for:
     * -> users in this room OK
     * -> items in this room
     * -> bots in this room
     * ...
    **/
    private final int id;
    private final String name;
    private final String description;
    private final int ownerId;
    private HashMap<Integer, User> users;

    public Room(ResultSet req) throws SQLException {
        this.id = req.getInt("id");
        this.name = req.getString("name");
        this.description = req.getString("description");
        this.ownerId = req.getInt("owner_id");
    }

    public HashMap<Integer, User> getUsers() {
        return this.users;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getOwnerId() {
        return this.ownerId;
    }
}
