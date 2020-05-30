import componet.BroomFactory;
import componet.Dictionary;
import componet.Moveable;
import componet.VehicleFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class SeeKumanSearchApplicationTestsTest {

    @Test
    public void main() {
        VehicleFactory factory = new BroomFactory();
        Moveable moveable = factory.create();
        /**
         * #Stage 1
         * Given a valid sentence without any spaces between the words and a dictionary of valid English words,
         * find all possible ways to break the sentence in individual dictionary words.
         */
        moveable.defaultRecursiveMatch(new Dictionary(),"ilikesamsungmobile").forEach(System.out::println);
        /**
         * #Stage 2 - new requirement to be implemented:
         * If user provide a customized dictionary of valid English words as additional input, and the
         * program will only find in the user customized dictionary
         */
        moveable.defaultRecursiveMatch(new Dictionary(new String[]{"i","like","samsung","mob","ile"}),"ilikesamsungmobile").forEach(System.out::println);
        /**
         * #Stage 3 - new requirement to be implemented:
         * If user provide a customized dictionary of valid English words as additional input, and the
         * program will find all the valid words in the both dictionaries
         */
        moveable.defaultRecursiveMatch(new Dictionary(new String[]{"mo","mobile"},""),"ilikesamsungmobile").forEach(System.out::println);
    }
}