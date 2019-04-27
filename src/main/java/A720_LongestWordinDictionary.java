import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class A720_LongestWordinDictionary {

    // 用HashSet保存符合条件的String集合
    public String longestWord(String[] words){
        Arrays.sort(words);
        Set<String> built = new HashSet<String>();
        String res = "";
        for(String word : words){
            if(word.length() == 1 || built.contains(word.substring(0, word.length()-1))){
                res = word.length() > res.length() ? word : res;
                built.add(word);
            }
        }
        return res;
    }

}
