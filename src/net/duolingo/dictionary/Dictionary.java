package net.duolingo.dictionary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dictionary {
    private Map<String, Set<String>> dictionaryOneWord = new HashMap<>();
    private Map<String, Set<String>> dictionaryPhrasalVerbs = new HashMap<>();
    private Set<String> listWords = new HashSet<>();

    public Dictionary() {
    }

    private String formatStr(String word) {
        return word.toLowerCase().trim();
    }

    private Boolean hasSameKeyOneWord(String character) {
        return dictionaryOneWord.containsKey(character);
    }

    private Boolean hasSameKeyPhrasalVerbs(String character) {
        return dictionaryPhrasalVerbs.containsKey(character);
    }

    private Boolean hasSameWordOneWord(String word, String character) {
        return dictionaryOneWord.get(character).contains(word);
    }

    private Boolean hasSameWordPhrasalVerbs(String word, String character) {
        return dictionaryPhrasalVerbs.get(character).contains(word);
    }

    private Boolean hasBlanks(String word) {
        int countBlank = word.indexOf(" ");
        if (countBlank != -1) {
            return true;
        }
        return false;
    }

    public void addWord(String word) {
        if (word.isEmpty() || word.isBlank()) {

            System.out.println("Error, has not entered any words");
            return;

        }

        word = formatStr(word);
        String character = word.toLowerCase().substring(0, 1);

        listWords = new HashSet<>();
        listWords.add(word);

        if (hasBlanks(word)) {
            if (hasSameKeyPhrasalVerbs(character)) {

                listWords = dictionaryPhrasalVerbs.get(character);
                listWords.add(word);
                dictionaryPhrasalVerbs.put(character, listWords);

            } else {

                dictionaryPhrasalVerbs.put(character, listWords);

            }
        } else {

            if (hasSameKeyOneWord(character)) {

                listWords = dictionaryOneWord.get(character);
                listWords.add(word);
                dictionaryOneWord.put(character, listWords);

            } else {

                dictionaryOneWord.put(character, listWords);

            }
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

        if (hasBlanks(word)) {
            if (hasSameKeyPhrasalVerbs(character)) {
                listWords = dictionaryPhrasalVerbs.get(character);
                if (hasSameWordPhrasalVerbs(word, character)) {
                    listWords.remove(word);
                    dictionaryPhrasalVerbs.put(character, listWords);
                }
            }
        } else {
            if (hasSameKeyOneWord(character)) {
                listWords = dictionaryOneWord.get(character);
                if (hasSameWordOneWord(word, character)) {
                    listWords.remove(word);
                    dictionaryOneWord.put(character, listWords);
                }
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
        if (hasBlanks(word)) {
            if (hasSameKeyPhrasalVerbs(character) && hasSameWordPhrasalVerbs(word, character)) {
                msg = "The phrasal verb " + word + " has been found.";
            }

        } else {
            if (hasSameKeyOneWord(character) && hasSameWordOneWord(word, character)) {
                msg = "The word " + word + " has been found.";

            }
        }

        System.out.println(msg);
    }

    public void showInitialAvailable() {

        System.out.println("Initial Available One Word: ");

        dictionaryOneWord.keySet().forEach((key) -> {
            System.out.println("-> " + key);
        });

        System.out.println("\nInitial Available Phrasal Verbs: ");

        dictionaryPhrasalVerbs.keySet().forEach((key) -> {
            System.out.println("-> " + key);
        });
    }

    public void showWordsWithInitial(String character) {
        String msg = "The character " + character + " not found in the dictionary.";

        if (character.isEmpty() || character.isBlank()) {

            System.out.println("Error, has not entered any character");
            return;

        }

        ArrayList<String> arrayWords = new ArrayList<>();
        character = formatStr(character);

        if (character.length() == 1) {

            if (hasSameKeyPhrasalVerbs(character)) {

                for (String word : dictionaryPhrasalVerbs.get(character)) {
                    arrayWords.add(word);
                }

            }

            if (hasSameKeyOneWord(character)) {

                for (String word : dictionaryOneWord.get(character)) {
                    arrayWords.add(word);
                }

            }

            msg = "The word with " + character + " are: \n";
            Collections.sort(arrayWords);

            for (String word : arrayWords) {
                msg += "-> " + word + ".\n";
            }

        }

        System.out.println(msg);

    }

}