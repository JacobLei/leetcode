import java.util.*;

interface Person{
    void eat();
}


public class A0_MyTest{

    public static void main(String[] args) {
        Collection s = new HashSet<Integer>();
        s.add(new Integer(1));
        s.add(new Integer(2));
        s.add(new Integer(3));

        for (Iterable i = (Iterable) s.iterator(); ((Iterator) i).hasNext();){

        }
    }

}
