package org.example;

import java.util.ArrayList;

public abstract class Animal {
    private int animalID;
    private String name;
    private String type;
    private String description;
    private String sound;
    private String history;
    private static ArrayList<Animal> animals = new ArrayList<>();

    public void setAnimalID(int animalID) {
        this.animalID = animalID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public int getAnimalID() {
        return animalID;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getSound() {
        return sound;
    }

    public String getHistory() {
        return history;
    }

    //get Sound, which is overridden in Mammal, Reptile and Amphibian Class
    public abstract String Sound();

    //get History, which is overridden in Mammal, Reptile and Amphibian Class
    public abstract String History() ;

    //return animals ArrayList
    public static ArrayList<Animal> getAnimals() {
        return animals;
    }

    //set animals ArrayList
    public static void setAnimals(ArrayList<Animal> animals) {
        Animal.animals = animals;
    }
}