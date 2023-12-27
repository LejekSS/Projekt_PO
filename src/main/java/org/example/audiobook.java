package org.example;

public class audiobook extends item {
    private int size;

    public float getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public audiobook(String name, String author, int publictionDate, int length, literaryGenres genre, int size) {
        super(name, author, publictionDate, length, genre);
        this.size = size;
    }
}



