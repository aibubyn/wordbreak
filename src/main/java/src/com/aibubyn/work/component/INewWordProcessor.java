package src.com.aibubyn.work.component;

import java.util.List;

public interface INewWordProcessor {

    void collect(String word);


    List<List<String>> process();
}
