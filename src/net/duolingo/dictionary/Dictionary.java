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
        String character = word.toLowerCase().substring(0, 1);
        Set<String> arrayWords = new HashSet<>();
        boolean hasSameKey = false;

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

}