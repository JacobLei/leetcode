import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A139_WordBreak {

    public boolean wordBreak(String s, List<String> wordDict){
        if (s == null || s.length() == 0)
            return true;

        Set<String> hashSet = new HashSet<>();
        for(String word : wordDict)
            hashSet.add(word);

        boolean[] res = new boolean[s.length()+1];
        res[0] = true;

        for(int i=1; i<=s.length(); i++){
            for(int j=0; j<i; j++){
                if(res[j] && hashSet.contains(s.substring(j, i))){
                    res[i] = true;
                    break;
                }
            }
        }

        return res[s.length()];
    }

    public static void main(String[] args) {
        A139_WordBreak wordBreak = new A139_WordBreak();
        String s = "leetcode";
        List<String> wordDict = Arrays.asList(new String[]{"leet", "code"});

        boolean res = wordBreak.wordBreak(s, wordDict);
        System.out.println(res);
    }
}
