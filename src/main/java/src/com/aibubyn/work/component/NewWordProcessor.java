package src.com.aibubyn.work.component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class NewWordProcessor implements INewWordProcessor {
    private StringBuilder builder;

    NewWordProcessor() {
        builder = new StringBuilder();
    }

    @Override
    public void collect(String word) {
        builder.append(word);
    }

    @Override
    public List<List<String>> process() {
        List<List<String>> result = new ArrayList<>();
        if (builder.length() == 0) {
            return result;
        }
        result.add(Arrays.asList(builder.toString()));
        builder.setLength(0);
        return result;
    }
}
