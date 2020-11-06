
package com.scuti;

import com.scuti.catalog.CatalogManager;
import com.scuti.core.ConfigurationManager;
import com.scuti.database.Database;
import com.scuti.rooms.RoomManager;
import com.scuti.networking.*;
import com.zaxxer.hikari.HikariDataSource;
import org.fusesource.jansi.AnsiConsole;

import java.sql.SQLException;

public class Emulator
{
    private static Scuti Scuti;
    private static final String  classPath = System.getProperty("java.class.path");
    private static final String osName = System.getProperty("os.name");

    // Colors
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String SUCCESS = ANSI_WHITE + "[" + ANSI_GREEN + "SUCCESS" + ANSI_WHITE + "] ";
    public static final String ERROR = ANSI_WHITE + "[" + ANSI_RED + "ERROR" + ANSI_WHITE + "] ";
    public static final String LOADING = ANSI_WHITE + "[" + ANSI_YELLOW + "LOADING" + ANSI_WHITE + "] ";
    public static final String INFO = ANSI_WHITE + "[" + ANSI_PURPLE + "INFO" + ANSI_WHITE + "] ";
    //Logo & version
    public final static String BUILD = "1.0-SNAPSHOT";
    public static final String version = "Scuti EMULATOR " + BUILD;
    private static final String logo =
            "\n" +
                    " ________  ________  ___  ___  _________  ___  _______   _____ ______   ___  ___     \n" +
                    "|\\   ____\\|\\   ____\\|\\  \\|\\  \\|\\___   ___\\\\  \\|\\  ___ \\ |\\   _ \\  _   \\|\\  \\|\\  \\    \n" +
                    "\\ \\  \\___|\\ \\  \\___|\\ \\  \\\\\\  \\|___ \\  \\_\\ \\  \\ \\   __/|\\ \\  \\\\\\__\\ \\  \\ \\  \\\\\\  \\   \n" +
                    " \\ \\_____  \\ \\  \\    \\ \\  \\\\\\  \\   \\ \\  \\ \\ \\  \\ \\  \\_|/_\\ \\  \\\\|__| \\  \\ \\  \\\\\\  \\  \n" +
                    "  \\|____|\\  \\ \\  \\____\\ \\  \\\\\\  \\   \\ \\  \\ \\ \\  \\ \\  \\_|\\ \\ \\  \\    \\ \\  \\ \\  \\\\\\  \\ \n" +
                    "    ____\\_\\  \\ \\_______\\ \\_______\\   \\ \\__\\ \\ \\__\\ \\_______\\ \\__\\    \\ \\__\\ \\_______\\\n" +
                    "   |\\_________\\|_______|\\|_______|    \\|__|  \\|__|\\|_______|\\|__|     \\|__|\\|_______|\n" +
                    "   \\|_________| " + ANSI_YELLOW + version + ANSI_WHITE + " - By Tig3r & Kozen\n" +

                    "" +
                    "                                                                                             ";

    public static void main(String[] args) throws SQLException {
        // SCUTI EMU

        if (osName.startsWith("Windows") && (!classPath.contains("idea_rt.jar"))) {
            AnsiConsole.systemInstall();
        }
        clearScreen();

        System.out.println( ANSI_WHITE + logo );
        System.out.println( INFO + version);

        // DATABASE
        ConfigurationManager.getConfiguration();
        Database.configure();

        // Scuti initialization
        Scuti = new Scuti();
        Scuti.preload();

        // GAMESERVER
        Server.connect();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static Scuti scuti() {
        return Scuti;
    }
}