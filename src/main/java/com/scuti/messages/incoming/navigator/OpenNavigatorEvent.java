package com.scuti.messages.incoming.navigator;

import com.scuti.Emulator;
import com.scuti.messages.incoming.IncomingEvent;
import com.scuti.messages.outgoing.Outgoing;
import com.scuti.messages.outgoing.OutgoingMessage;
import org.json.JSONObject;

import java.io.IOException;

public class OpenNavigatorEvent extends IncomingEvent {
    @Override
    public void handle() throws IllegalAccessException, InstantiationException, IOException {

        JSONObject output = new JSONObject();

        Class<? extends OutgoingMessage> classMessage = Emulator.scuti().getOutgoingMessageManager().getMessages().get(Outgoing.RoomNavigatorListMessage);
        OutgoingMessage message = classMessage.newInstance();
        message.client = this.session;
        message.data = output;

        message.compose();
    }
}
