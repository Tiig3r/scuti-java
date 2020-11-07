package com.scuti.messages.outgoing;

import com.scuti.messages.outgoing.navigator.NavigatorRoomMessage;
import com.scuti.messages.outgoing.rooms.LoadRoomMessage;
import com.scuti.messages.outgoing.user.UserLoginMessage;

import java.util.HashMap;

public class OutgoingMessageManager {
    private final HashMap<Integer, Class<? extends OutgoingMessage>> messages;

    public OutgoingMessageManager() {
        this.messages = new HashMap<>();

        this.registerMessages();
    }

    public HashMap<Integer, Class<? extends OutgoingMessage>> getMessages() {
        return this.messages;
    }

    public void registerMessages() {

        this.messages.put(Outgoing.UserLoginMessage, UserLoginMessage.class);
        this.messages.put(Outgoing.RoomNavigatorListMessage, NavigatorRoomMessage.class);
        this.messages.put(Outgoing.LoadRoomMessage, LoadRoomMessage.class);

    }

}
