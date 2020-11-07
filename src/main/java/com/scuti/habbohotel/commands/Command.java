package com.scuti.habbohotel.commands;

public abstract class Command {

    public final String name;
    public final String[] keys;

    public Command(String name, String[] keys) {
        this.name = name;
        this.keys = keys;
    }

    public abstract void run() throws Exception;
}
