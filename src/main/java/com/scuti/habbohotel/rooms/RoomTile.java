package com.scuti.habbohotel.rooms;

public class RoomTile {
    private final double x;
    private final double y;
    private double z;
    private double stackHeight;
    private boolean allowStack;

    public RoomTile(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public double distance(RoomTile tile) {
        double dx = this.getX() - tile.getX();
        double dy = this.getY() - tile.getY();
        double dz = this.getZ() - tile.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
}
