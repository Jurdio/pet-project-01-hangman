package com.hangman.game.core;

import com.hangman.game.words.WordDictionary;

import java.util.Scanner;

public class HangmanGame {
    private WordDictionary wordDictionary;
    HangmanGame(){
        wordDictionary = new WordDictionary();
    }
    public static void main(String[] args) {
        new HangmanGame().startGame();
    }
    private void startGame(){
        while (true){
            displayWelcomeScreen();
            try{
                Scanner scanner = new Scanner(System.in);
                int userChoice = scanner.nextInt();


                switch (userChoice){
                    case 1:

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
                System.out.println("Invalid choice. Please enter a valid option.");
            }
        }


    }
    private void displayWelcomeScreen(){
        System.out.println("Hello, it`s Hangman game. You can see rules or start play\n" +
                "1 - Start play\n" +
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
    private void displayGameplay(String word){

    }
}
