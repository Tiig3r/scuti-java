package com.scuti.messages.incoming;

import org.eclipse.jetty.websocket.api.Session;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.SQLException;

public abstract class IncomingEvent {
    public JSONObject data;
    public Session session;
    public abstract void handle() throws SQLException, IllegalAccessException, InstantiationException, IOException;
}
