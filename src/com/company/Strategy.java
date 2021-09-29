package com.company;

public class Strategy {

    private final User user;

    public Strategy() {
        user = new User();
    }
    public String selectStrategy(String current) {

        String currentComp = current.equals("One") ?  "One" :  "Two";
        System.out.println("Enter the number 1 or 2 to select your strategy game for Computer " + currentComp + ": \n" +
                "1 - Always Random.\n" +
                "2 - Always Rock.\n"
        );
        String strategy = user.getUserInput();
        if (!user.isInputStrategyValid(strategy)) {
            selectStrategy(current);
        }
        return strategy;
    }
}
