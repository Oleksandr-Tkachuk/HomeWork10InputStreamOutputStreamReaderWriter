package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Task3 {
    public static void main(String[] args) {
        String fileName = "words.txt";
        Map<String, Integer> wordFrequency = calculateWordFrequency(fileName);
        printWordFrequency(wordFrequency);
    }

    public static Map<String, Integer> calculateWordFrequency(String fileName) {
        Map<String, Integer> wordFrequency = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, Integer> sortedWordFrequency = sortByValueDescending(wordFrequency);
        return sortedWordFrequency;
    }

    public static void printWordFrequency(Map<String, Integer> wordFrequency) {
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }


    public static Map<String, Integer> sortByValueDescending(Map<String, Integer> map) {
        Map<String, Integer> sortedMap = new TreeMap<>((word1, word2) -> {
            int freqCompare = map.get(word2).compareTo(map.get(word1));
            if (freqCompare == 0) {
                return word1.compareTo(word2);
            }
            return freqCompare;
        });
        sortedMap.putAll(map);
        return sortedMap;
    }
}