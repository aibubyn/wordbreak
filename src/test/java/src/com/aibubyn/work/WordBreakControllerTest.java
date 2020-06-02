package src.com.aibubyn.work;
import org.junit.Test;
import src.com.aibubyn.work.component.NewWordProcessorFactory;

import java.util.List;


public class WordBreakControllerTest {

    @Test
    public void main() {
        String [] userDictionary=new String[]{"i", "like", "sam", "sung", "mobile", "icecream", "man go", "mango"};

        FmmWork fmmWork = new FmmWork(NewWordProcessorFactory.getInstance());


        System.out.println("------------first------------");
        String sentence = "ilikesamsungmobile";
        List<String> result = fmmWork.wordBreak(sentence, FmmWork.SearchMode.ONLY_PUBLIC,null);
        WordBreakController.println(sentence, result);




        System.out.println("------------second------------");
        sentence = "ilikesamsungmobile";
        result = fmmWork.wordBreak(sentence, FmmWork.SearchMode.ONLY_USER,userDictionary);
        WordBreakController.println(sentence, result);



        System.out.println("------------#third------------");
        sentence = "ilikesamsungmobileicecreamand";
        result = fmmWork.wordBreak(sentence, FmmWork.SearchMode.ALL,userDictionary);
        WordBreakController.println(sentence, result);
    }
}
