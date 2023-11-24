package com.hangman.game.core;

import com.hangman.game.words.WordDictionary;

import java.util.Scanner;

public class GameLogic {
    private String word;
    private char[] letterArray;
    private WordDictionary wordDictionary;
    private Gallows gallows;
    StringBuilder hiddenWordBuilder;
    public GameLogic(){
        wordDictionary = new WordDictionary();
        word = wordDictionary.getRandomWord();
        gallows = new Gallows();
        letterArray = word.toCharArray();
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
    private void updateHiddenWord(char guessedLetter){
        for (int i = 0; i < letterArray.length; i++){
            if (letterArray[i] == guessedLetter){
                hiddenWordBuilder.setCharAt(i * 2 + 1, guessedLetter);
            }
        }

    }
    private void displayHiddenWord(){
        System.out.println(hiddenWordBuilder.toString());
    }

    public void guessingCycle(){
        Scanner guessingScanner = new Scanner(System.in);
        String userInput;
        while (!gallows.isGameOver()){
            userInput = guessingScanner.next();
            if (!wordContainsLetter(userInput)){
                gallows.updateIncorrectAttempts();
            } else {
                System.out.println("Right!");
                updateHiddenWord(userInput.charAt(0));;
            }
            gallows.displayGallows();
            displayHiddenWord();
        }
        System.out.println("Game over! " +
                "Your word is : " + word);
    }


}
