package com.scuti.messages.outgoing.items;

import com.scuti.Emulator;
import com.scuti.habbohotel.items.Item;
import com.scuti.habbohotel.users.User;
import com.scuti.messages.outgoing.OutgoingMessage;

import java.io.IOException;

public class MoveItemMessage extends OutgoingMessage {
    @Override
    public void compose() throws IOException {

        // TODO: / ! \   Verification -> if the tile on which we want to put item is taken by an other item   / ! \

        User user = Emulator.scuti().gameClientManager().getClients().get(this.client);
        int roomId = this.data.getJSONObject("data").getInt("roomId");
        int itemId = this.data.getJSONObject("data").getInt("itemId");
        // New positions
        int x = this.data.getJSONObject("data").getJSONObject("positions").getInt("x");
        int y = this.data.getJSONObject("data").getJSONObject("positions").getInt("y");
        int z = this.data.getJSONObject("data").getJSONObject("positions").getInt("z");

        if(user.isOwner(Emulator.scuti().getRoomManager().getRoomsLoaded().get(roomId))) {
            Item item = Emulator.scuti().getItemManager().getItems().get(itemId);
            if(item.getRoom() == roomId) {
                item.setX(1);
                item.setY(1);
                item.setZ(1);
                // Instantiate MoveItemMessage class to return smthg to the client
            }
        }
    }
}
