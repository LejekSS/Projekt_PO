package org.example;

public abstract class databaseObject {
    private String name;
    private int id;
    private long date;
    private static int lastID = 0;

    public databaseObject(String name) {
        this.name = name;
        this.id = ++lastID;
        this.date = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return  "id= " + id +
                ", name= '" + name + '\'' +
                ", date= " + date;
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

    public static int getLastID() {
        return lastID;
    }

    public static void setLastID(int lastID) {
        databaseObject.lastID = lastID;
    }
}
