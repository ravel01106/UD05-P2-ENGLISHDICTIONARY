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

    private String formatStr(String phrase) {
        return phrase.toLowerCase().trim();
    }

    private Boolean hasSameKey(String initial, Map<String, Set<String>> dictionary) {
        return dictionary.containsKey(initial);
    }

    private Boolean hasSamePhrase(String initial, String phrase, Map<String, Set<String>> dictionary) {
        return dictionary.get(initial).contains(phrase);
    }

    private Boolean hasBlanks(String phrase) {

        int countBlank = phrase.indexOf(" ");
        if (countBlank != -1) {
            return true;
        }
        return false;

    }

    public void addWord(String phrase) {

        if (phrase.isEmpty() || phrase.isBlank()) {
            System.out.println("Error, has not entered any words");
            return;
        }

        phrase = formatStr(phrase);
        String initial = phrase.toLowerCase().substring(0, 1);
        String msg = "The word " + phrase + " has been added correctly.";

        listWords = new HashSet<>();
        listWords.add(phrase);

        if (hasBlanks(phrase)) {
            if (hasSameKey(initial, dictionaryPhrasalVerbs)) {
                listWords = dictionaryPhrasalVerbs.get(initial);
                listWords.add(phrase);
                dictionaryPhrasalVerbs.put(initial, listWords);

            } else {
                dictionaryPhrasalVerbs.put(initial, listWords);

            }
            msg = "The phrasal verb " + phrase + " has been added correctly.";
        } else {

            if (hasSameKey(initial, dictionaryOneWord)) {
                listWords = dictionaryOneWord.get(initial);
                listWords.add(phrase);
                dictionaryOneWord.put(initial, listWords);

            } else {
                dictionaryOneWord.put(initial, listWords);

            }
        }

        System.out.println(msg);

    }

    public void deleteWord(String phrase) {

        if (phrase.isEmpty() || phrase.isBlank()) {
            System.out.println("Error, has not entered any words");
            return;

        }

        phrase = formatStr(phrase);
        String initial = phrase.toLowerCase().substring(0, 1);
        String msg = "There is no word that can be deleted";

        if (hasBlanks(phrase)) {

            if (hasSameKey(initial, dictionaryPhrasalVerbs)) {
                listWords = dictionaryPhrasalVerbs.get(initial);

                if (hasSamePhrase(initial, phrase, dictionaryPhrasalVerbs)) {
                    listWords.remove(phrase);
                    dictionaryPhrasalVerbs.put(initial, listWords);
                    msg = "The phrasal verb " + phrase + " has been removed correctly.";
                }
            }
        } else {

            if (hasSameKey(initial, dictionaryOneWord)) {
                listWords = dictionaryOneWord.get(initial);

                if (hasSamePhrase(initial, phrase, dictionaryOneWord)) {
                    listWords.remove(phrase);
                    dictionaryOneWord.put(initial, listWords);
                    msg = "The word " + phrase + " has been removed correctly.";
                }

            }
        }

        System.out.println(msg);
    }

    public void existWord(String phrase) {

        if (phrase.isEmpty() || phrase.isBlank()) {

            System.out.println("Error, has not entered any words");
            return;

        }

        phrase = formatStr(phrase);
        String initial = phrase.toLowerCase().substring(0, 1);
        String msg = "The word " + phrase + " not found in the dictionary.";

        if (hasBlanks(phrase)) {
            if (hasSameKey(initial, dictionaryPhrasalVerbs) && hasSamePhrase(initial, phrase, dictionaryPhrasalVerbs)) {
                msg = "The phrasal verb " + phrase + " has been found.";
            }

        } else {
            if (hasSameKey(initial, dictionaryOneWord) && hasSamePhrase(initial, phrase, dictionaryOneWord)) {
                msg = "The word " + phrase + " has been found.";

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

    public void showWordsWithInitial(String initial) {
        String msg = "The initial " + initial + " not found in the dictionary.";

        if (initial.isEmpty() || initial.isBlank()) {

            System.out.println("Error, has not entered any initial");
            return;

        }

        ArrayList<String> arrayWords = new ArrayList<>();
        initial = formatStr(initial);

        if (initial.length() == 1) {

            if (hasSameKey(initial, dictionaryPhrasalVerbs)) {

                for (String word : dictionaryPhrasalVerbs.get(initial)) {
                    arrayWords.add(word);
                }

            }

            if (hasSameKey(initial, dictionaryOneWord)) {

                for (String word : dictionaryOneWord.get(initial)) {
                    arrayWords.add(word);
                }

            }

            msg = "The word with " + initial + " are: \n";
            Collections.sort(arrayWords);

            for (String word : arrayWords) {
                msg += "-> " + word + ".\n";
            }

        }

        System.out.println(msg);

    }

}