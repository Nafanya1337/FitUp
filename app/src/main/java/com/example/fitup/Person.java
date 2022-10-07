package com.example.fitup;

public class Person {
    private String name;
    private String surname;

    private int weight;
    private int height;
    private int age;

    {
        name = "Имя Фамилия";
        weight = 70;
        height = 175;
        age = 20;
    }

    public Person(){}

    // wha - weight, height, age
    public Person(String[] bio, int... wha){
        try {
            name = bio[0];
            surname = bio[1];
        }
        catch (ArrayIndexOutOfBoundsException fail){}

        try {
            weight = wha[0];
            height = wha[1];
            age = wha[2];
        }
        catch (ArrayIndexOutOfBoundsException fail){}
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
