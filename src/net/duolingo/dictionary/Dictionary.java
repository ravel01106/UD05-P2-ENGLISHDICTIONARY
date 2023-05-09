package net.duolingo.dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dictionary {
    private Map<String, Set<String>> dictionaryEnglish = new HashMap<>();

    public Dictionary() {
    }

    public Map<String, Set<String>> getDictionaryEnglish() {
        return dictionaryEnglish;
    }

    private String formatWord(String word) {
        return word.toLowerCase().trim();
    }

    private Boolean hasSameKey(String character) {
        for (String key : dictionaryEnglish.keySet()) {
            if (key.equals(character)) {
                return true;
            }
        }
        return false;
    }

    private Boolean hasSameWord(String word, String character) {
        for (String wordInArray : dictionaryEnglish.get(character)) {
            if (wordInArray.equals(word)) {
                return true;
            }
        }
        return false;
    }

    public void addWord(String word) {
        if (word.isEmpty() || word.isBlank()) {

            System.out.println("Error, has not entered any words");
            return;

        }

        word = formatWord(word);
        String character = word.toLowerCase().substring(0, 1);
        Set<String> arrayWords = new HashSet<>();

        if (dictionaryEnglish.size() == 0) {

            arrayWords.add(word);
            dictionaryEnglish.put(character, arrayWords);

        } else {

            if (!hasSameKey(character)) {

                arrayWords.add(word);
                dictionaryEnglish.put(character, arrayWords);

            } else {

                arrayWords = dictionaryEnglish.get(character);
                arrayWords.add(word);
                dictionaryEnglish.put(character, arrayWords);

            }

        }

        System.out.println("The word " + word + " has been registered correctly.");

    }

    public void deleteWord(String word) {

        if (word.isEmpty() || word.isBlank()) {

            System.out.println("Error, has not entered any words");
            return;

        }

        word = formatWord(word);
        String character = word.toLowerCase().substring(0, 1);
        Set<String> arrayWords = new HashSet<>();
        String msg = "There is no word that can be deleted";

        if (dictionaryEnglish.size() != 0) {

            if (hasSameKey(character)) {

                arrayWords = dictionaryEnglish.get(character);

                if (hasSameWord(word, character)) {

                    arrayWords.remove(word);
                    dictionaryEnglish.put(character, arrayWords);
                    msg = "The word " + word + " has been deleted correctly";

                }

            }

        }

        System.out.println(msg);
    }

}