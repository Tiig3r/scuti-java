package com.scuti.messages.incoming.rooms;

import com.scuti.Emulator;
import com.scuti.messages.incoming.IncomingEvent;
import com.scuti.messages.outgoing.Outgoing;
import com.scuti.messages.outgoing.OutgoingMessage;
import org.json.JSONObject;

import java.io.IOException;

public class LoadRoomEvent extends IncomingEvent {
    @Override
    public void handle() throws IllegalAccessException, InstantiationException, IOException {

        int roomId = this.data.getJSONObject("data").getInt("roomId");

        JSONObject output = new JSONObject();
        output.put("roomId", roomId);

        Class<? extends OutgoingMessage> classMessage = Emulator.scuti().getOutgoingMessageManager().getMessages().get(Outgoing.LoadRoomMessage);
        OutgoingMessage message = classMessage.newInstance();
        message.client = this.session;
        message.data = output;

        message.compose();
    }
}
