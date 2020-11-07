package com.scuti.messages.outgoing.rooms;

import com.scuti.Emulator;
import com.scuti.habbohotel.items.Item;
import com.scuti.messages.incoming.Incoming;
import com.scuti.messages.outgoing.Outgoing;
import com.scuti.messages.outgoing.OutgoingMessage;
import com.scuti.habbohotel.rooms.Room;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class LoadRoomMessage extends OutgoingMessage {
    @Override
    public void compose() throws IOException {

        int roomId = (Integer) this.data.get("roomId");

        Room room = Emulator.scuti().getRoomManager().getRoom(roomId);

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
        for(Item item: room.getItems().values()) {
            JSONObject itemData = new JSONObject();

            // Get item data (position, rotation, and what you want :p )
            itemData.put("x", item.getX());
            itemData.put("y", item.getX());
            itemData.put("z", item.getX());

            roomItems.put(Integer.toString(item.getId()), itemData);
        }

        data.put("roomItems", roomItems);

        roomsPacket.put("data", data);
        this.client.getRemote().sendString(roomsPacket.toString());
    }
}
