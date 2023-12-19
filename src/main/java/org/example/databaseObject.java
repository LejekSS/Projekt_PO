package org.example;

public class databaseObject {
    private String name;
    private int id;
    private long date;
    private static int lastID = 0;

    public databaseObject(String name, long date) {
        this.name = name;
        this.id = ++lastID;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public static int getLastID() {
        return lastID;
    }

    public static void setLastID(int lastID) {
        databaseObject.lastID = lastID;
    }
}
