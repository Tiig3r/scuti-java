package com.scuti.database;

import com.scuti.Emulator;
import com.scuti.core.ConfigurationManager;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Database {
    private static HikariDataSource database;
    public static void configure() {
        long millis = System.currentTimeMillis();
        try {
            HikariConfig dbConfig = new HikariConfig();
            dbConfig.setDriverClassName("com.mysql.jdbc.Driver");
            dbConfig.setJdbcUrl("jdbc:mysql://" + ConfigurationManager.dbhost + ":" + ConfigurationManager.dbport + "/" + ConfigurationManager.dbname + "");
            dbConfig.setUsername(ConfigurationManager.dbuser);
            dbConfig.setPassword(ConfigurationManager.dbpass);

            database = new HikariDataSource(dbConfig);
        } catch (Exception e) {
            System.out.println(Emulator.ERROR + "Unable to connect to the database.");
            System.exit(0);
        }
        System.out.println(Emulator.SUCCESS + "Database manager -> OK! (" + (System.currentTimeMillis() - millis) + " MS)");
    }

    public static HikariDataSource getDB() {
        return database;
    }
}
