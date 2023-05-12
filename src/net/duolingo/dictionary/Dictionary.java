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

    private Boolean hasSameKeyOneWord(String initial) {
        return dictionaryOneWord.containsKey(initial);
    }

    private Boolean hasSameKeyPhrasalVerbs(String initial) {
        return dictionaryPhrasalVerbs.containsKey(initial);
    }

    private Boolean hasSamePhraseOneWord(String phrase, String initial) {
        return dictionaryOneWord.get(initial).contains(phrase);
    }

    private Boolean hasSamePhrasePhrasalVerbs(String phrase, String initial) {
        return dictionaryPhrasalVerbs.get(initial).contains(phrase);
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

        listWords = new HashSet<>();
        listWords.add(phrase);

        if (hasBlanks(phrase)) {
            if (hasSameKeyPhrasalVerbs(initial)) {
                listWords = dictionaryPhrasalVerbs.get(initial);
                listWords.add(phrase);
                dictionaryPhrasalVerbs.put(initial, listWords);

            } else {
                dictionaryPhrasalVerbs.put(initial, listWords);

            }
        } else {

            if (hasSameKeyOneWord(initial)) {
                listWords = dictionaryOneWord.get(initial);
                listWords.add(phrase);
                dictionaryOneWord.put(initial, listWords);

            } else {
                dictionaryOneWord.put(initial, listWords);

            }
        }

        System.out.println("The word " + phrase + " has been registered correctly.");

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

            if (hasSameKeyPhrasalVerbs(initial)) {
                listWords = dictionaryPhrasalVerbs.get(initial);

                if (hasSamePhrasePhrasalVerbs(phrase, initial)) {
                    listWords.remove(phrase);
                    dictionaryPhrasalVerbs.put(initial, listWords);
                }
            }
        } else {

            if (hasSameKeyOneWord(initial)) {
                listWords = dictionaryOneWord.get(initial);

                if (hasSamePhraseOneWord(phrase, initial)) {
                    listWords.remove(phrase);
                    dictionaryOneWord.put(initial, listWords);
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
            if (hasSameKeyPhrasalVerbs(initial) && hasSamePhrasePhrasalVerbs(phrase, initial)) {
                msg = "The phrasal verb " + phrase + " has been found.";
            }

        } else {
            if (hasSameKeyOneWord(initial) && hasSamePhraseOneWord(phrase, initial)) {
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

            if (hasSameKeyPhrasalVerbs(initial)) {

                for (String word : dictionaryPhrasalVerbs.get(initial)) {
                    arrayWords.add(word);
                }

            }

            if (hasSameKeyOneWord(initial)) {

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