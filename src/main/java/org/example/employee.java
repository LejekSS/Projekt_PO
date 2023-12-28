package org.example;

import java.util.Scanner;

public class employee extends person{
    private workplaces position;
    private int salary;

    public employee(String name, genders gender, int age, String identityCard, workplaces position, int salary) {
        super(name, gender, age, identityCard);
        this.position = position;
        this.salary = salary;
    }

    public static workplaces setPosition() {
        Scanner scanner = new Scanner(System.in);
        workplaces position = null;
        boolean isValid = false;
        while (!isValid) {
            System.out.println("Podaj stanowisko: ");
            String userInput = scanner.nextLine().trim();
            try {
                position = workplaces.valueOf(userInput.toUpperCase());
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Podano nieprawidłowe stanowiskio zatrudnienia.");
            }
        }
        return position;
    }

    public workplaces getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", position=" + position +
                ", salary=" + salary;
    }

    @Override
    public void ageup() {
            setAge(getAge()+1);
            setSalary(getSalary()+200);
    }
}
