package com.scuti.rooms;

import com.scuti.Emulator;
import com.scuti.database.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class RoomManager {
    private final HashMap<Integer, Room> rooms;

    public RoomManager() {
        this.rooms = new HashMap<Integer, Room>();
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
            System.out.println(Emulator.ERROR + "Unable to load room manager!");
            System.exit(0);
        }
        System.out.println(Emulator.SUCCESS + "Room manager -> OK! (" + (System.currentTimeMillis() - millis) + " MS)");
    }

    public HashMap<Integer, Room> getRoomsLoaded() {
        return this.rooms;
    }
}
