package src.com.aibubyn.work;

import src.com.aibubyn.work.component.Dictionary;
import src.com.aibubyn.work.component.INewWordProcessor;
import src.com.aibubyn.work.component.INewWordProcessorFactory;
import src.com.aibubyn.work.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class FmmWork {
    public enum SearchMode {
        ALL, ONLY_PUBLIC, ONLY_USER
    }

    private Dictionary publicDictionary;
    private INewWordProcessorFactory newWordProcessorFactory;

    FmmWork(INewWordProcessorFactory newWordProcessorFactory) {
        this.publicDictionary =  new Dictionary();
        this.newWordProcessorFactory = newWordProcessorFactory;
    }

    public List<String> wordBreak(final String sentence, SearchMode mode, String [] isJoin) {
        Dictionary dictionary = selectDictionary(mode,isJoin);
        List<List<String>> result = wordBreak(sentence, dictionary, dictionary.getMaxLength(),false);
        return result.stream().map(e -> String.join(" ", e)).collect(Collectors.toList());
    }


    private List<List<String>> wordBreak(final String sentence, Dictionary dictionary, int maxLength, boolean isSub) {
        List<List<String>> result = new ArrayList<>();
        if (sentence == null || sentence.isEmpty()) {
            return result;
        }

        INewWordProcessor newWordProcessor = newWordProcessorFactory.getNewWordProcessor();
        int minLength = dictionary.getMinLength();
        int pointer = 0;
        int len = sentence.length();
        while (pointer < len) {
            int upper = Math.min(len, pointer + maxLength);
            String sub;
            Set<String> searchResults;

            do {
                sub = sentence.substring(pointer, upper);
                searchResults = dictionary.search(sub);
                upper --;
            } while (searchResults.isEmpty() && upper - pointer >= minLength);


            if (searchResults.isEmpty() && isSub) {
                result.clear();
                return result;
            }

            int subLen = sub.length();
            if (subLen > minLength * 2) {
                List<List<String>> r = wordBreak(sub, dictionary, subLen - 1, true);
                r.stream().filter(l -> !l.isEmpty()).map(l -> String.join(" ", l)).forEach(searchResults::add);
            }
            if (searchResults.isEmpty()) {
                newWordProcessor.collect(sub);
            } else {

                result.addAll(newWordProcessor.process());
                result.add(new ArrayList<>(searchResults));
            }
            pointer += subLen;
        }

        result.addAll(newWordProcessor.process());
        return CollectionUtils.descartes(result);
    }



    private Dictionary selectDictionary(SearchMode mode, String [] dictionaryStr) {
        switch (mode) {
            case ALL:
                return new Dictionary(dictionaryStr,true);
            case ONLY_USER:
                return new Dictionary(dictionaryStr,false);
            case ONLY_PUBLIC:
            default:
                return new Dictionary();
        }
    }
}