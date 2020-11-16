package com.scuti.messages.outgoing.navigator;

import com.scuti.Emulator;
import com.scuti.messages.outgoing.Outgoing;
import com.scuti.messages.outgoing.OutgoingMessage;
import com.scuti.habbohotel.rooms.Room;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class MyRoomsMessage extends OutgoingMessage {
    @Override
    public void compose() throws IOException {
        JSONObject roomsPacket = new JSONObject();
        JSONObject data = new JSONObject();

        roomsPacket.put("packetId", Outgoing.MyRoomsMessage);

        System.out.println("My rooms message");

        for(Room room : Emulator.scuti().getRoomManager().getRoomsLoaded().values()) {
            if(room.getOwnerId() == Emulator.scuti().gameClientManager().getClients().get(this.client).getId()) {
                JSONObject roomData = new JSONObject();

                // owner id -> owner name
                roomData.put("id", room.getId());
                roomData.put("name", room.getName());
                roomData.put("ownerId", room.getOwnerId());
                roomData.put("ownerName", room.getOwnerName());
                roomData.put("description", room.getDescription());
                //roomData.put("wallHeight", room.getWallHeight());
                //roomData.put("floorThickness", room.getFloorThickness());
                //roomData.put("heightmap", Emulator.scuti().getRoomManager().getModelsLoaded().get(room.getHeightmapId()).getHeightmap());
                roomData.put("maxUsers", room.getMaxUsers());
                roomData.put("users", room.getUsers().size());
                roomData.put("state", room.getState());

                data.put(Integer.toString(room.getId()), roomData);
            }
        }

        roomsPacket.put("data", data);
        this.client.getRemote().sendString(roomsPacket.toString());
    }
}
