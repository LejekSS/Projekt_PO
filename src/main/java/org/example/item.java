package org.example;

public abstract class item extends databaseObject{
    private String title;
    private String author;
    private int publictionDate;
    private int length;
    private literaryGenres genre;

    public item(String name, long date, String title, String author, int publictionDate, int length, literaryGenres genre) {
        super(name, date);
        this.title = title;
        this.author = author;
        this.publictionDate = publictionDate;
        this.length = length;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublictionDate() {
        return publictionDate;
    }

    public void setPublictionDate(int publictionDate) {
        this.publictionDate = publictionDate;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public literaryGenres getGenre() {
        return genre;
    }

    public void setGenre(literaryGenres genre) {
        this.genre = genre;
    }
}