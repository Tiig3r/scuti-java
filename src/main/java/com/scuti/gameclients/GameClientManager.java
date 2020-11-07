package com.scuti.gameclients;

import com.scuti.habbohotel.users.User;
import org.eclipse.jetty.websocket.api.Session;

import java.util.HashMap;

public class GameClientManager {
    private final HashMap<Session, User> clients;

    public GameClientManager() {
        this.clients = new HashMap<>();
    }

    public HashMap<Session, User> getClients() {
        return this.clients;
    }
}
