package com.scuti.messages.outgoing.navigator;

import com.scuti.Emulator;
import com.scuti.messages.outgoing.Outgoing;
import com.scuti.messages.outgoing.OutgoingMessage;
import com.scuti.habbohotel.rooms.Room;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class NavigatorRoomMessage extends OutgoingMessage {
    @Override
    public void compose() throws IOException {

        HashMap<Integer, Room> rooms = Emulator.scuti().getRoomManager().getRoomsLoaded();
        JSONObject roomsPacket = new JSONObject();
        JSONObject data = new JSONObject();

        roomsPacket.put("packetId", Outgoing.RoomNavigatorListMessage);

        for(Room room : rooms.values()) {
            JSONObject roomData = new JSONObject();

            // owner id -> owner name
            roomData.put("id", room.getId());
            roomData.put("name", room.getName());
            roomData.put("ownerId", room.getOwnerId());
            roomData.put("ownerName", room.getOwnerName());
            roomData.put("description", room.getDescription());
            roomData.put("wallHeight", room.getWallHeight());
            roomData.put("floorThickness", room.getFloorThickness());
            roomData.put("heightmap", room.getHeightmap());

            data.put(Integer.toString(room.getId()), roomData);
        }

        roomsPacket.put("data", data);
        this.client.getRemote().sendString(roomsPacket.toString());
    }
}
