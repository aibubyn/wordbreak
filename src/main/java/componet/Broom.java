package componet;

import java.util.*;

public class Broom implements Moveable {


    @Override
    public Set<String> defaultRecursiveMatch(Dictionary dictionary,String str) {
        Set<String> strings = dictionary.SearchNewSet(str);
        return dictionary.defaultRecursiveMatch(strings);
    }



}
