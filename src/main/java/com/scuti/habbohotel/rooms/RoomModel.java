package com.scuti.habbohotel.rooms;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomModel {
    private final int id;
    private final int doorX;
    private final int doorY;
    private final int doorDirection;
    private final String heightmap;

    public RoomModel(ResultSet set) throws SQLException {
        this.id = set.getInt("id");
        this.doorX = set.getInt("door_x");
        this.doorY = set.getInt("door_y");
        this.doorDirection = set.getInt("door_dir");
        this.heightmap = set.getString("heightmap");
    }

    public int getId() {
        return this.id;
    }

    public int getDoorX() {
        return this.doorX;
    }

    public int getDoorY() {
        return this.doorY;
    }

    public int getDoorDirection() {
        return this.doorDirection;
    }

    public String getHeightmap() {
        return this.heightmap;
    }

}
