package com.scuti.networking;

import com.scuti.core.ConfigurationManager;
import com.scuti.networking.gameserver.*;
import static spark.Spark.*;

public class Server {
    public static void connect() {
        port(Integer.parseInt(ConfigurationManager.port));
        webSocket("/", GameServer.class);
        init();
    }
}