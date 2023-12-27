package org.example;

import java.time.LocalDate;

public abstract class databaseObject {
    private String name;
    private int id;
    private LocalDate date;
    private static int lastID = 0;

    public databaseObject(String name) {
        this.name = name;
        this.id = ++lastID;
        this.date = LocalDate.now();
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

    public LocalDate getDate() {
        return date;
    }

    public static int getLastID() {
        return lastID;
    }

}
