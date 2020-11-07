package com.scuti.messages.outgoing.rooms;

import com.scuti.Emulator;
import com.scuti.messages.outgoing.Outgoing;
import com.scuti.messages.outgoing.OutgoingMessage;
import com.scuti.habbohotel.rooms.Room;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class LoadRoomMessage extends OutgoingMessage {
    @Override
    public void compose() throws IOException {

        Integer roomId = (Integer) this.data.get("roomId");

        Room room = Emulator.scuti().getRoomManager().getRoom(roomId);

        JSONObject roomsPacket = new JSONObject();
        JSONObject data = new JSONObject();

        roomsPacket.put("packetId", Outgoing.LoadRoomMessage);

        JSONObject roomData = new JSONObject();

        roomData.put("roomId", room.getId());
        roomData.put("heightmap", room.getHeightmap().replace('\r', 'x'));
        roomData.put("floorThickness", room.getFloorThickness());
        roomData.put("wallHeight", room.getWallHeight());

        data.put(Integer.toString(room.getId()), roomData);


        roomsPacket.put("data", roomData);
        this.client.getRemote().sendString(roomsPacket.toString());
    }
}
