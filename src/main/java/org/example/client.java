package org.example;

import java.util.Arrays;

public class client extends person{
    public void setRented(int[] rented) {
        this.rented = rented;
    }

    private int[] rented;

    public int[] getRented() {
        return rented;
    }

    public client(String name, genders gender, int age, String identityCard) {
        super(name, gender, age, identityCard);
        this.rented = new int[0];
    }

    @Override
    public String toString() {
        return super.toString() +
                ", rented=" + Arrays.toString(rented);
    }
}
