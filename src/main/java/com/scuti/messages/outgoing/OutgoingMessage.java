package com.scuti.messages.outgoing;

import org.eclipse.jetty.websocket.api.Session;
import org.json.JSONObject;

import java.io.IOException;

public abstract class OutgoingMessage {
    public JSONObject data;
    public Session client;

    public abstract void compose() throws IOException;
}
