package com.hangman.game.words;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordDictionary {
    private static List<String> words;

    public WordDictionary() {
        words = new ArrayList<>();
    }

    public WordDictionary(String filePath) {
        words = new ArrayList<>();
        parseWordsFromFile(filePath);
    }

    private void parseWordsFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Додавання слів з файлу до словника
                words.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getRandomWord() {
        if (words.isEmpty()) {
            throw new IllegalStateException("The dictionary is empty.");
        }

        Random random = new Random();
        int randomIndex = random.nextInt(words.size());
        return words.get(randomIndex);
    }
}
