package com.scuti.messages.outgoing.user;

import com.scuti.messages.outgoing.Outgoing;
import com.scuti.messages.outgoing.OutgoingMessage;
import org.json.JSONObject;

import java.io.IOException;

public class UserLoginMessage extends OutgoingMessage {
    @Override
    public void compose() throws IOException {
        JSONObject packet = new JSONObject();
        JSONObject data = new JSONObject();
        JSONObject user = new JSONObject();

        user.put("username", this.data.get("username"));

        data.put("isLogged", true);
        data.put("user", user);

        packet.put("packetId", Outgoing.UserLoginMessage);
        packet.put("data", data);

        this.client.getRemote().sendString(packet.toString());
    }
}
