package org.library.model;

import org.library.utils.literaryGenres;

import java.util.Arrays;

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

    @Override
    public String toString() {
        return super.toString() +
                ", size=" + size;
    }

    public void rent(client klient, audiobook audiobook) {
            int[] newRented = Arrays.copyOf(klient.getRented(), klient.getRented().length + 1);
            for (int id : newRented) {
                if (id == audiobook.getId()) {
                    System.out.println( "Ten audiobook znajduję się już na liście wypożyczonych przez użytkownika");
                    return;
                }
                else {
                    newRented[newRented.length - 1] = audiobook.getId();
                    klient.setRented(newRented);
                    System.out.println( "Wypożyczono audiobook");
                    return;
                }
            }
    }


}



