package com.scuti.messages.outgoing;

import com.scuti.messages.outgoing.navigator.NavigatorRoomMessage;
import com.scuti.messages.outgoing.user.UserLoginMessage;

import java.util.HashMap;

public class OutgoingMessageManager {
    private final HashMap<Integer, Class<? extends OutgoingMessage>> messages;

    public OutgoingMessageManager() {
        this.messages = new HashMap<>();

        this.registerUserMessage();
        this.registerNavigatorMessage();
    }

    public HashMap<Integer, Class<? extends OutgoingMessage>> getMessages() {
        return this.messages;
    }

    public void registerUserMessage() {
        this.messages.put(Outgoing.UserLoginMessage, UserLoginMessage.class);
    }

    public void registerNavigatorMessage() {
        this.messages.put(Outgoing.RoomNavigatorListMessage, NavigatorRoomMessage.class);
    }
}
