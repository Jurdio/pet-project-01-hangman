package com.hangman.game.core;

import java.util.Scanner;

public class HangmanGame {
    public static void main(String[] args) {
        new HangmanGame().startGame();
    }
    private void startGame(){
        int userChoice;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello, it`s Hangman game. You can see rules or start play");

        while (true){
            displayWelcomeScreen();

            try {
                // Перевірка, чи введено тільки одну цифру від 1 до 3
                if (!scanner.hasNext("[1-3]")) {
                    throw new IllegalArgumentException("Invalid input, please enter a number between 1 and 3!");
                }

                userChoice = scanner.nextInt();

                switch (userChoice){
                    case 1:
                        System.out.println("Let`s start play!");
                        starGameplay();
                        break;
                    case 2:
                        displayRules();
                        break;
                    case 3:
                        System.out.println("Exiting the game. Goodbye!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.\n");
                        break;
                }
            } catch (Exception e){
                System.out.println("Invalid input, try again!");
                scanner.nextLine();  // Очистити буфер введення
            }
        }
    }
    private void displayWelcomeScreen(){
        System.out.println("1 - Start play\n" +
                "2 - View rules\n" +
                "3 - Exit");
    }
    private void displayRules(){
        System.out.println("Hangman Rules:\n" +
                "1. Goal: Guess the word before running out of attempts.\n" +
                "2. Word: The word is represented by underscores.\n" +
                "3. Attempts: Limited attempts (usually 6).\n" +
                "4. Input: Enter letters or the whole word to guess.\n" +
                "5. Mistakes: Incorrect letters reveal parts of a hangman.\n" +
                "6. Win or Lose: Win by guessing the word; lose by running out of attempts.\n");
    }
    private void starGameplay(){
        new GameLogic().guessingCycle();
    }
}
