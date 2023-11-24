package com.hangman.game.words;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordDictionary {
    private static List<String> words;
    private final String filePath = "/dictionary.txt";
    public WordDictionary() {
        words = new ArrayList<>();
        parseWordsFromFile(filePath);
    }
    private void parseWordsFromFile(String filePath) {
        try (InputStream inputStream = getClass().getResourceAsStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader reader = new BufferedReader(inputStreamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getRandomWord() {
        if (words.isEmpty()) {
            throw new IllegalStateException("The dictionary is empty.");
        }

        Random random = new Random();
        int randomIndex = random.nextInt(words.size());
        return words.get(randomIndex);
    }
}
