package src.com.aibubyn.work.component;

import java.util.*;

public class Dictionary {
    private Set<String> dictionary=new HashSet<>(Arrays.asList(new String[]{"i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "man go"}));
    private Map<String, Set<String>> actualWords;
    private int maxLength;
    private int minLength;

    public Dictionary(String[] dictionaryStr,Boolean isJoin) {
        this.dictionary = loadFile(dictionaryStr,isJoin);
        this.actualWords = new HashMap<>();
        this.maxLength = 0;
        this.minLength = Integer.MAX_VALUE;
        for (String word : dictionary) {
            String newWord = word.replaceAll("[\\s-]", "");
            this.maxLength = Math.max(maxLength, newWord.length());
            this.minLength = Math.min(minLength, newWord.length());
        }
    }
    public Dictionary() {
        this.dictionary = dictionary;
        this.actualWords = new HashMap<>();
        this.maxLength = 0;
        this.minLength = Integer.MAX_VALUE;
        for (String word : dictionary) {
            String newWord = word.replaceAll("[\\s-]", "");
            this.maxLength = Math.max(maxLength, newWord.length());
            this.minLength = Math.min(minLength, newWord.length());
        }
    }
    public Set<String> loadFile(String[] dictionaryStr,Boolean isJoin) {
        if(isJoin) {
            Set<String> newDictionarySet = new HashSet<>(Arrays.asList(dictionaryStr));
            dictionary.addAll(newDictionarySet);
        }else{
            dictionary=new HashSet<>(Arrays.asList(dictionaryStr));
        }

        return dictionary;
    }


    public Set<String> search(String word) {
        Set<String> words = actualWords.get(word);
        if (words == null) {
            words = new HashSet<>();
            if (dictionary.contains(word)) {
                words.add(word);
            }
        }
        return words;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public int getMinLength() {
        return minLength;
    }


}