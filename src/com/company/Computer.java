package com.company;

import java.util.Random;

public class Computer {

    private String randomChoice;
    int seed = 123456;
    Random rnd = new Random(seed);

    public String selectRandomChoice() {
        int choice = rnd.nextInt((3 - 1) + 1) + 1;

        if (choice == 1) {
            randomChoice = "Rock";
        }
        if (choice == 2) {
            randomChoice = "Paper";
        }
        if (choice == 3) {
            randomChoice = "Scissors";
        }
        return randomChoice;
    }
    public String selectAlwaysChoice() {
        return "Rock";
    }

}
