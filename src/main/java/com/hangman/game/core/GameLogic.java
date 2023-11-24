package com.hangman.game.core;

import com.hangman.game.words.WordDictionary;

import java.util.Arrays;
import java.util.Scanner;

public class GameLogic {
    private final String word;
    private final char[] letterArray;
    private final Gallows gallows;
    private StringBuilder hiddenWordBuilder;
    public GameLogic(){
        WordDictionary wordDictionary = new WordDictionary();
        gallows = new Gallows();
        word = wordDictionary.getRandomWord();
        letterArray = new char[word.length()];
        initializeHiddenWord();
    }
    public boolean wordContainsLetter(String letter){
        return word.contains(String.valueOf(letter));
    }
    private void initializeHiddenWord(){
        hiddenWordBuilder = new StringBuilder("[");

        for (int i = 0; i < word.length(); i++){
            hiddenWordBuilder.append("_");

            if (i < word.length() - 1){
                hiddenWordBuilder.append(" ");
            }
        }
        hiddenWordBuilder.append("]");
    }
    private void updateHiddenWord(char guessedLetter) {
        for (int i = 0; i < word.length(); i++) {
            char[] tempLetterArray = word.toCharArray();
            if (Character.toLowerCase(tempLetterArray[i]) == guessedLetter) {
                hiddenWordBuilder.setCharAt(i * 2 + 1, guessedLetter);
                letterArray[i] = guessedLetter;
            }
        }
    }
    private void displayHiddenWord(){
        System.out.println(hiddenWordBuilder.toString());
    }
    public void guessingCycle(){
        int failCounter = 0;
        Scanner guessingScanner = new Scanner(System.in);
        String userInput;

        do {
            displayHiddenWord();
            if (Arrays.equals(letterArray, word.toCharArray())) {
                System.out.println("Congratulations! You guessed the word!");
                break;
            }
            try {
                userInput = guessingScanner.next();

                // Перевірка, чи введено тільки одну англійську букву
                if (!userInput.matches("[a-zA-Z]")) {
                    throw new IllegalArgumentException("Invalid input, please enter a single English letter!");
                }
            } catch (Exception e){
                System.out.println("Invalid input, try again!");
                guessingScanner.nextLine();  // Очистити буфер введення
                continue;  // Почати цикл спочатку
            }

            if (!wordContainsLetter(userInput.toLowerCase())){
                gallows.updateIncorrectAttempts();
                gallows.displayGallows();
                System.out.println("Number of failures :" + ++failCounter);
            } else {
                System.out.println("Right!");
                updateHiddenWord(userInput.toLowerCase().charAt(0));
            }
        } while (!gallows.isGameOver());

        System.out.println("Game over! " + (gallows.isGameOver() ? "You lose\n" : "\n") +
                "Your word is : " + word);
    }
}
