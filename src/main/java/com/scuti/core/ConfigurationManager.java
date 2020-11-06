package com.scuti.core;

import org.ini4j.*;
import com.scuti.Emulator;
import java.io.File;


public class ConfigurationManager {
    public static String dbhost;
    public static String dbport;
    public static String dbname;
    public static String dbuser;
    public static String dbpass;
    public static String port;

    public static void getConfiguration() {
        long millis = System.currentTimeMillis();

        try {
            Wini ini = new Wini(new File("config.ini"));
            dbhost = ini.get("database", "dbhost");
            dbport = ini.get("database", "dbport");
            dbname = ini.get("database", "dbname");
            dbuser = ini.get("database", "dbuser");
            dbpass = ini.get("database", "dbpass");
            port = ini.get("server", "port");
        } catch(Exception e) {
            System.err.println(Emulator.ERROR + e.getMessage());
            System.exit(0);
        }

        System.out.println(Emulator.SUCCESS + "Configuration manager -> OK! (" + (System.currentTimeMillis() - millis) + " MS)");
    }
}
