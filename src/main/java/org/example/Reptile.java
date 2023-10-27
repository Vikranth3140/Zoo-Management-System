package org.example;

public class Reptile extends Animal {

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