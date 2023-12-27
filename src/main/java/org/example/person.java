package org.example;

import java.util.Scanner;

public abstract class person extends databaseObject{
    private genders gender;
    private int age;
    private String identityCard;
    public person(String name, genders gender, int age, String identityCard) {
        super(name);
        this.gender = gender;
        this.age = age;
        this.identityCard = identityCard;
    }
    public static genders setGender() {
        Scanner scanner = new Scanner(System.in);
        genders gender = null;
        boolean isValid = false;
        while (!isValid) {
            System.out.println("Podaj płeć: ");
            String userInput = scanner.nextLine().trim();
            try {
                gender = genders.valueOf(userInput.toUpperCase());
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Podano nieprawidłową płeć.");
            }
        }
        return gender;
    }

    public genders isGender() {
        return gender;
    }

    public void setGender(genders gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", gender=" + gender +
                ", age=" + age +
                ", identityCard='" + identityCard + '\'';
    }
}
