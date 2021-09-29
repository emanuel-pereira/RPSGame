package com.company;

import static java.lang.Integer.parseInt;

public class Game {

    private final User user;
    private final Computer computer;
    private final Strategy strategy;
    private int computerOneScore;
    private int computerTwoScore;
    private int rounds;
    private boolean computerOneWins;
    private boolean computerTwoWins;
    private boolean isTie;

    public Game() {
        computerOneScore = 0;
        computerTwoScore = 0;
        rounds = 0;
        computerOneWins = false;
        computerTwoWins = false;
        isTie = false;
        user = new User();
        strategy = new Strategy();
        computer = new Computer();
        start();
    }

    private void start() {
        boolean keepPlaying = true;
        String startIn, nrGamesIn;

        while (keepPlaying) {

            System.out.println("Press S Enter for start a new game or Q Enter to quit.");
            startIn = user.getUserInput();
            resetScores();

            if (startIn.equalsIgnoreCase("Q")) {
                keepPlaying = false;
            } else if (user.isValidInput(startIn)) {
                System.out.println("How many rounds you want them play?");
                nrGamesIn = user.getUserInput();

                if (user.isInputNrGamesValid(nrGamesIn)) {
                    displayMatches(strategy.selectStrategy("One"), strategy.selectStrategy("Two"), nrGamesIn);
                    System.out.println(getScoreReportStr());
                }
            }
        }
        System.out.println("Bye for now.");
    }

    private void displayMatches(String strategyComputer1, String strategyComputer2, String nrGamesIn) {


        int nrOfGames = parseInt(nrGamesIn);
        for (int i = 0; i < nrOfGames; i++) {

            String computerOne = strategyComputer1.equals("1") ? computer.selectRandomChoice() : computer.selectAlwaysChoice();
            String computerTwo = strategyComputer2.equals("1") ? computer.selectRandomChoice() : computer.selectAlwaysChoice();

            playRound(computerOne, computerTwo);

            System.out.println("The computer One choose: " + computerOne);
            System.out.println("The computer Two choose: " + computerTwo);

            if (isComputerOneWins()) {
                System.out.println("Computer One wins!");
            } else if (isComputerTwoWins()) {
                System.out.println("Computer Two wins!");
            } else if (isTie()) {
                System.out.println("It's a tie!");
            }
        }
    }

    private void playRound(String computerOne, String computerTwo) {

        resetRound();
        if ((computerOne.equals("Rock") && computerTwo.equals("Scissors"))
                || (computerOne.equals("Paper") && computerTwo.equals("Rock"))
                || (computerOne.equals("Scissors") && computerTwo.equals("Paper"))) {
            rounds++;
            computerOneWins = true;
            computerOneScore++;
        } else if ((computerOne.equals("Rock") && computerTwo.equals("Paper"))
                || (computerOne.equals("Scissors") && computerTwo.equals("Rock"))
                || (computerOne.equals("Paper") && computerTwo.equals("Scissors"))) {
            rounds++;
            computerTwoWins = true;
            computerTwoScore++;
        } else {
            rounds++;
            isTie = true;
        }
    }

    public boolean isComputerOneWins() {
        return this.computerOneWins;
    }

    public boolean isComputerTwoWins() {
        return this.computerTwoWins;
    }

    public boolean isTie() {
        return this.isTie;
    }

    public String getScoreReportStr() {
        return ("Total plays: " + rounds + "; Computer One Score: " + computerOneScore + "; Computer Two score: " + computerTwoScore);
    }

    public void resetRound() {
        computerOneWins = false;
        computerTwoWins = false;
        isTie = false;
    }

    public void resetScores() {
        rounds = 0;
        computerOneScore = 0;
        computerTwoScore = 0;
    }

}
