package com.scuti.messages.outgoing.rooms;

import com.scuti.Emulator;
import com.scuti.habbohotel.items.Item;
import com.scuti.messages.incoming.Incoming;
import com.scuti.messages.outgoing.Outgoing;
import com.scuti.messages.outgoing.OutgoingMessage;
import com.scuti.habbohotel.rooms.Room;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class LoadRoomMessage extends OutgoingMessage {
    @Override
    public void compose() throws IOException {

        int roomId = (Integer) this.data.get("roomId");

        Room room = Emulator.scuti().getRoomManager().getRoom(roomId);
        room.initItems();

        JSONObject roomsPacket = new JSONObject();
        roomsPacket.put("packetId", Outgoing.LoadRoomMessage);

        // Packet data
        JSONObject data = new JSONObject();

        data.put("roomId", room.getId());
        data.put("heightmap", room.getHeightmap().replace('\r', 'x'));
        data.put("floorThickness", room.getFloorThickness());
        data.put("wallHeight", room.getWallHeight());

        // Room item data
        JSONObject roomItems = new JSONObject();
        JSONArray furniArray = new JSONArray();
        for(Item item: room.getItems().values()) {
            JSONObject itemData = new JSONObject();
            JSONObject position = new JSONObject();

            // Get item data (position, rotation, and what you want :p )
            itemData.put("id", item.getId());
            itemData.put("baseId", item.getItemBaseId());

            // Coordinates
            position.put("x", item.getX());
            position.put("y", item.getY());
            position.put("z", item.getZ());
            itemData.put("positions", position);

            itemData.put("direction", item.getRotation());
            itemData.put("state", 0);
            //TODO: item state

            furniArray.put(itemData);
        }

        data.put("furnitures", furniArray);

        roomsPacket.put("data", data);
        this.client.getRemote().sendString(roomsPacket.toString());
    }
}
