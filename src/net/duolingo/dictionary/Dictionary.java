package net.duolingo.dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dictionary {
    private Map<String, Set<String>> dictionaryEnglish = new HashMap<>();
    private Set<String> listWords = new HashSet<>();

    public Dictionary() {
    }

    public Map<String, Set<String>> getDictionaryEnglish() {
        return dictionaryEnglish;
    }

    private String formatStr(String word) {
        return word.toLowerCase().trim();
    }

    private Boolean hasSameKey(String character) {
        return dictionaryEnglish.containsKey(character);
    }

    private Boolean hasSameWord(String word, String character) {
        return dictionaryEnglish.get(character).contains(word);
    }

    public void addWord(String word) {
        if (word.isEmpty() || word.isBlank()) {

            System.out.println("Error, has not entered any words");
            return;

        }

        word = formatStr(word);
        String character = word.toLowerCase().substring(0, 1);

        if (hasSameKey(character)) {
            listWords = dictionaryEnglish.get(character);
            listWords.add(word);
            dictionaryEnglish.put(character, listWords);

        } else {

            listWords = new HashSet<>();
            listWords.add(word);
            dictionaryEnglish.put(character, listWords);

        }

        System.out.println("The word " + word + " has been registered correctly.");

    }

    public void deleteWord(String word) {

        if (word.isEmpty() || word.isBlank()) {

            System.out.println("Error, has not entered any words");
            return;

        }

        word = formatStr(word);
        String character = word.toLowerCase().substring(0, 1);
        String msg = "There is no word that can be deleted";

        if (hasSameKey(character)) {

            listWords = dictionaryEnglish.get(character);

            if (hasSameWord(word, character)) {

                listWords.remove(word);
                dictionaryEnglish.put(character, listWords);
                msg = "The word " + word + " has been deleted correctly";

            }

        }

        System.out.println(msg);
    }

    public void existWord(String word) {

        if (word.isEmpty() || word.isBlank()) {

            System.out.println("Error, has not entered any words");
            return;

        }
        word = formatStr(word);
        String character = word.toLowerCase().substring(0, 1);
        String msg = "The word " + word + " not found in the dictionary.";

        if (hasSameKey(character)) {

            if (hasSameWord(word, character)) {

                msg = "The word " + word + " has been found.";

            }

        }
        System.out.println(msg);
    }

    public void showInitialAvailable() {

        System.out.println("Initial Available: ");

        dictionaryEnglish.keySet().forEach((key) -> {
            System.out.println("-> " + key);
        });

    }

    public void showWordsWithInitial(String character) {
        String msg = "The character " + character + " is not an initial.";

        if (character.isEmpty() || character.isBlank()) {

            System.out.println("Error, has not entered any character");
            return;

        }

        character = formatStr(character);

        if (character.length() == 1) {

            if (hasSameKey(character)) {

                System.out.println("Words which initial is " + character + ":");

                dictionaryEnglish.get(character).forEach((word) -> {
                    System.out.println("-> " + word);
                });

                msg = "";

            } else {

                msg = "The character " + character + " not found in the dictionary.";

            }

        }

        System.out.println(msg);

    }

}