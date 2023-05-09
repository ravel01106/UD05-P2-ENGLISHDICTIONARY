package net.duolingo.dictionary;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Dictionary {
    private Map<String, Set<String>> dictionaryEnglish = new HashMap<>();

    public Dictionary() {
    }

    public Map<String, Set<String>> getDictionaryEnglish() {
        return dictionaryEnglish;
    }

}