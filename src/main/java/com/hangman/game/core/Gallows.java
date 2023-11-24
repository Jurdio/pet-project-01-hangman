package com.hangman.game.core;

public class Gallows {
    private int incorrectAttempts;
    private boolean isGameOver = false;

    public boolean isGameOver() {
        return isGameOver;
    }

    public Gallows() {
        this.incorrectAttempts = 0;
    }

    public void updateIncorrectAttempts() {
        incorrectAttempts++;
    }



    public void displayGallows() {
        switch (incorrectAttempts) {
            case 0:
                System.out.println("  ______");
                System.out.println("  |    |");
                System.out.println("  |     ");
                System.out.println("  |     ");
                System.out.println("  |     ");
                System.out.println("__|_______");
                break;
            case 1:
                System.out.println("  ______");
                System.out.println("  |    |");
                System.out.println("  |    0");
                System.out.println("  |     ");
                System.out.println("  |     ");
                System.out.println("__|_______");
                break;
            case 2:
                System.out.println("  ______");
                System.out.println("  |    |");
                System.out.println("  |    0");
                System.out.println("  |    |");
                System.out.println("  |    ");
                System.out.println("__|_______");
                break;
            case 3:
                System.out.println("  ______");
                System.out.println("  |    |");
                System.out.println("  |    0");
                System.out.println("  |   /| ");
                System.out.println("  |     ");
                System.out.println("__|_______");
                break;
            case 4:
                System.out.println("  ______");
                System.out.println("  |    |");
                System.out.println("  |    0");
                System.out.println("  |   /|\\");
                System.out.println("  |    ");
                System.out.println("__|_______");
                break;
            case 5:
                System.out.println("  ______");
                System.out.println("  |    |");
                System.out.println("  |    0");
                System.out.println("  |   /|\\");
                System.out.println("  |   / ");
                System.out.println("__|_______");
                break;
            case 6:
                System.out.println("  ______");
                System.out.println("  |    |");
                System.out.println("  |    0");
                System.out.println("  |   /|\\");
                System.out.println("  |   / \\");
                System.out.println("__|_______");
                isGameOver = true;
                break;
        }
    }
}