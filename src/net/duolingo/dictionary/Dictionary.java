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

    public void addWord(String word) {
        word = formatWord(word);
        String character = word.toLowerCase().substring(0, 1);
        Set<String> arrayWords = new HashSet<>();
        boolean hasSameKey = false;
        word = formatWord(word);

        if (dictionaryEnglish.size() == 0) {

            arrayWords.add(word);
            dictionaryEnglish.put(character, arrayWords);

        } else {

            Set<String> keys = dictionaryEnglish.keySet();

            for (String key : keys) {
                if (key.equals(character)) {
                    hasSameKey = true;
                }
            }

            if (!hasSameKey) {

                arrayWords.add(word);
                dictionaryEnglish.put(character, arrayWords);

            } else {

                arrayWords = dictionaryEnglish.get(character);
                arrayWords.add(word);
                dictionaryEnglish.put(character, arrayWords);

            }
        }

    }

    public String formatWord(String word) {
        return word.toLowerCase().trim();
    }

    public void deleteWord(String word) {
        word = formatWord(word);
        String character = word.toLowerCase().substring(0, 1);
        Set<String> arrayWords = new HashSet<>();
        boolean hasSameKey = false;
        String msg = "There is no word that can be deleted";

        if (dictionaryEnglish.size() != 0) {
            Set<String> keys = dictionaryEnglish.keySet();

            for (String key : keys) {
                if (key.equals(character)) {
                    hasSameKey = true;
                }
            }

            if (hasSameKey) {
                arrayWords = dictionaryEnglish.get(character);
                boolean hasSameValue = false;
                for (String wordInArray : arrayWords) {
                    if (wordInArray.equals(word)) {
                        hasSameValue = true;
                    }
                }
                if (hasSameValue) {
                    arrayWords.remove(word);
                    dictionaryEnglish.put(character, arrayWords);
                    msg = "The word " + word + " has been deleted correctly";
                }

            }
        }
        System.out.println(msg);
    }

}