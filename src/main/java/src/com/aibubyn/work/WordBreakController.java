package src.com.aibubyn.work;

import src.com.aibubyn.work.component.NewWordProcessorFactory;

import java.util.Collection;
import java.util.List;

public class WordBreakController {
    public static void main(String[] args) {
        String [] userDictionary=new String[]{"i", "like", "sam", "sung", "mobile", "icecream", "man go", "mango"};

        FmmWork fmmWork = new FmmWork(NewWordProcessorFactory.getInstance());


        System.out.println("------------first------------");
        String sentence = "ilikeicecreamandmango";
        List<String> result = fmmWork.wordBreak(sentence, FmmWork.SearchMode.ONLY_PUBLIC,null);
        println(sentence, result);




        System.out.println("------------second------------");
         sentence = "ilikesamsungmobile";
         result = fmmWork.wordBreak(sentence, FmmWork.SearchMode.ONLY_USER,userDictionary);
        println(sentence, result);



        System.out.println("------------#third------------");


        sentence = "ilikeicecreamandmango";
        result = fmmWork.wordBreak(sentence, FmmWork.SearchMode.ALL,userDictionary);
        println(sentence, result);
    }

    public static void println(String input, Collection<String> collection) {
        System.out.println("input: ");
        System.out.println(input);
        System.out.println("output: ");
        collection.forEach(System.out::println);
        System.out.println();
    }
}