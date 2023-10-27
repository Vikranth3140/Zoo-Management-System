package org.example;

public class Mammal extends Animal {

    //get Sound
    @Override
    public String Sound() {
        return getSound();
    }

    //get History
    @Override
    public String History() {
        return getHistory();
    }
}