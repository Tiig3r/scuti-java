package com.scuti.networking.gameserver;

import com.scuti.Emulator;
import com.scuti.messages.incoming.IncomingEvent;
import org.eclipse.jetty.websocket.api.*;
import org.eclipse.jetty.websocket.api.annotations.*;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.SQLException;

@WebSocket
public class GameServer {

    @OnWebSocketConnect
    public void onConnect(Session user) throws Exception {

    }

    @OnWebSocketClose
    public void onClose(Session user, int statusCode, String reason) {
        System.out.println(user.getRemoteAddress().getHostName().concat(" is disconnected!"));
    }

    @OnWebSocketMessage
    public void onMessage(Session user, String message) throws IOException, IllegalAccessException, InstantiationException, SQLException {
        JSONObject data = new JSONObject(message);

        //System.out.println(msg.toString());
        if(data.has("packetId") && data.has("data")) {
            if(Emulator.scuti().getIncomingEventManager().getEvents().containsKey(data.getInt("packetId"))) {
                Class<? extends IncomingEvent> eventClass = Emulator.scuti().getIncomingEventManager().getEvents().get(data.getInt("packetId"));
                IncomingEvent event = eventClass.newInstance();
                event.data = data;
                event.session = user;
                event.handle();
            } else {
                System.out.println("This packet id does not exist!");
            }
        } else {
            System.out.println("Invalid packet received!");
        }
    }

}
