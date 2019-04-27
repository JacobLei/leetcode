import java.util.HashSet;
import java.util.Set;

public class A14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        int pos = 0;

        while(true){
            Set<Character> set = new HashSet<>();
            for(int i=0; i<strs.length; i++){
                if(pos >= strs[i].length()){
                    break;
                }
                set.add(strs[i].charAt(pos));
            }
            if(set.size() != 1){
                break;
            }
            res += strs[0].charAt(pos++);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
