package com.scuti.habbohotel.rooms;

import com.scuti.Emulator;
import com.scuti.database.Database;
import com.scuti.habbohotel.users.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RoomManager {
    private final HashMap<Integer, Room> rooms;
    private final HashMap<Integer, RoomModel> models;

    public RoomManager() {
        this.rooms = new HashMap<Integer, Room>();
        this.models = new HashMap<Integer, RoomModel>();
    }

    public void loadRooms() {
        long millis = System.currentTimeMillis();
        try(Connection connection = Database.getDB().getConnection()) {
            try(Statement statement = connection.createStatement()) {
                try(ResultSet req = statement.executeQuery("SELECT * FROM rooms")) {
                    while(req.next()) {
                        this.rooms.put(req.getInt("id"), new Room(req));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(Emulator.ERROR + "Unable to load room manager! Error: " + e);
            System.exit(0);
        }
        System.out.println(Emulator.SUCCESS + "Room manager -> OK! (" + (System.currentTimeMillis() - millis) + " MS)");
    }

    public void loadModels() {
        long millis = System.currentTimeMillis();
        try(Connection connection = Database.getDB().getConnection()) {
            try(Statement statement = connection.createStatement()) {
                try(ResultSet req = statement.executeQuery("SELECT * FROM room_models")) {
                    while(req.next()) {
                        this.models.put(req.getInt("id"), new RoomModel(req));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(Emulator.ERROR + "Unable to load room models!");
            System.exit(0);
        }
        System.out.println(Emulator.SUCCESS + "Room models -> OK! (" + (System.currentTimeMillis() - millis) + " MS)");
    }

    public HashMap<Integer, Room> getRoomsLoaded() {
        return this.rooms;
    }

    public HashMap<Integer, RoomModel> getModelsLoaded() {
        return this.models;
    }

}
