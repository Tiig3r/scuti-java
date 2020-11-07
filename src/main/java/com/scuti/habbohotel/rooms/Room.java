package com.scuti.habbohotel.rooms;

import com.scuti.Emulator;
import com.scuti.habbohotel.items.Item;
import com.scuti.habbohotel.users.User;

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
    private final String ownerName;
    private final int wallHeight;
    private final int thicknessFloor;
    private final String heightmap;
    private HashMap<Integer, User> users;
    private HashMap<Integer, Item> items;
    //private final TIntObjectMap<Item> roomItems;

    public Room(ResultSet req) throws SQLException {
        this.id = req.getInt("id");
        this.name = req.getString("name");
        this.description = req.getString("description");
        this.ownerId = req.getInt("owner_id");
        this.ownerName = req.getString("owner_name");
        this.wallHeight = req.getInt("wall_height");
        this.thicknessFloor = req.getInt("thickness_floor");
        this.heightmap = req.getString("heightmap");
        System.out.println("Room '" + req.getString("name") + "' loaded!");
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

    public String getOwnerName() {
        return this.ownerName;
    }

    public int getWallHeight() { return this.wallHeight; }

    public int getFloorThickness() {
        return this.thicknessFloor;
    }

    public String getHeightmap() {
        return this.heightmap;
    }

    public void initItems() {
        for(Item item: Emulator.scuti().getItemManager().getItems().values()) {
            if(item.getRoom() == this.id) {
                this.items.put(item.getId(), item);
            }
        }
    }

    public HashMap<Integer, Item> getItems() {
        return this.items;
    }

    public void addItem(Item item) {
        this.items.put(item.getId(), item);
    }

    //public THashSet<Item> getFloorItems() {
    //    THashSet<Item> items = new THashSet<>();
    //}
}
