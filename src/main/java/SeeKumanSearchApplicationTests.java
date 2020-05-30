import componet.BroomFactory;
import componet.Moveable;
import componet.VehicleFactory;
import componet.Dictionary;

public class SeeKumanSearchApplicationTests {
    public static void main(String[] args) {
        VehicleFactory factory = new BroomFactory();
        Moveable moveable = factory.create();
        moveable.defaultRecursiveMatch(new Dictionary(),"ilikesamsungmobileuu").forEach(System.out::println);
        moveable.defaultRecursiveMatch(new Dictionary(new String[]{"i","like","samsung","mob","ileuu"}),"ilikesamsungmobileuu").forEach(System.out::println);
        moveable.defaultRecursiveMatch(new Dictionary(new String[]{"ileuu"},""),"ilikesamsungmobileuu").forEach(System.out::println);
    }
}
