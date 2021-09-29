package com.company;

import java.util.Scanner;

public class User {

    public User() {
    }
    public String getUserInput() {
        Scanner read = new Scanner(System.in);
        return read.nextLine();
    }
    public boolean isValidInput(String input) {
        if (input.equals("S")) {
            System.out.println("Ok, let´s go!");
            return true;
        } else {
            return false;
        }
    }
    public boolean isInputStrategyValid(String input) {
        if (input.equals("1") || input.equals("2")) {
            return true;
        } else {
            System.out.println("Please, entry a valid strategy number!");
            return false;
        }
    }
    public boolean isInputNrGamesValid(String input) {
            if (input.matches("[0-9]+")) {
            return true;
        } else {
            System.out.println("Please, entry a valid number of games!");
            return false;
        }
    }

}
