import java.util.HashSet;
import java.util.Set;

public class A859_BuddyStrings {
    public static void main(String[] args) {
        String str = "abc.d+efg";
        str = str.replace(".", "");
        str = str.substring(0, str.indexOf('+'));
        System.out.println(str);
    }
}
