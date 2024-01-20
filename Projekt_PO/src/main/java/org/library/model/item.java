package org.library.model;

import org.library.utils.literaryGenres;

import java.util.Scanner;

public abstract class item extends databaseObject {
    public static literaryGenres setGenre() {
        Scanner scanner = new Scanner(System.in);
        literaryGenres genre = null;
        boolean isValid = false;
        while (!isValid) {
            System.out.println("Podaj gatunek literacki: ");
            String userInput = scanner.nextLine().trim();
            try {
                genre = literaryGenres.valueOf(userInput.toUpperCase());
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Podano nieprawidłowy gatunek literacki.");
            }
        }

        return genre;
    }
    private String author;
    private int publictionDate;
    private int length;
    private literaryGenres genre;

    public item(String name, String author, int publictionDate, int length, literaryGenres genre) {
        super(name);
        this.author = author;
        this.publictionDate = publictionDate;
        this.length = length;
        this.genre = genre;
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

    @Override
    public String toString() {
        return super.toString() +
                ", author='" + author + '\'' +
                ", publictionDate=" + publictionDate +
                ", length=" + length +
                ", genre=" + genre
                ;
    }
}
