package org.example;

public class audiobook extends item{
    private float size;

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public audiobook(String name, String author, int publictionDate, int length, literaryGenres genre, float size) {
        super(name, author, publictionDate, length, genre);
        this.size = size;
    }
}
