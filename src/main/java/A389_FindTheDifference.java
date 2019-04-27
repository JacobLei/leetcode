import java.util.HashMap;
import java.util.Map;

public class A389_FindTheDifference {
    public char findTheDifference(String s, String t){
        char ret = 0;

        for(Character c : s.toCharArray()){
                ret ^= c;
        }

        for(Character c : t.toCharArray()){
            ret ^= c;
        }

        return ret;
    }

    public static void main(String[] args) {
        A389_FindTheDifference findTheDifference = new A389_FindTheDifference();
        String s = new String("abcd");
        String t = new String("abcde");

        System.out.println(findTheDifference.findTheDifference(s, t));

    }
}
