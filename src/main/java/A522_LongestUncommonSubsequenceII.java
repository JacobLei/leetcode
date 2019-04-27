import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class A522_LongestUncommonSubsequenceII {
    public int findLUSlength(String[] strs){
        Arrays.sort(strs, (o1, o2)->{
            return o2.length() - o1.length();
        });

        Set<String> duplicates = getDuplicates(strs);
        for (int i = 0; i < strs.length; i++) {
            if(!duplicates.contains(strs[i])){
                if(i == 0) return strs[0].length(); // 第0个元素不是重复元素，返回此元素即可
                for (int j = 0; j < i; j++) {       // 从第0个元素到第i个元素，判断第i个元素是否是子序列
                    if(isSubsequence(strs[j], strs[i])) break;
                    if(j == i-1) return strs[i].length();
                }

            }
        }
        return -1;
    }

    private boolean isSubsequence(String a, String b) {
        int i = 0, j = 0;
        while(i < a.length() && j < b.length()){
            if(a.charAt(i) == b.charAt(j)) j++;
            i++;
        }
        return j == b.length();
    }

    private Set<String> getDuplicates(String[] strs) {
        Set<String> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        for (String s : strs){
            if(set.contains(s))
                res.add(s);
            set.add(s);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"aba", "a", "ba"};
        A522_LongestUncommonSubsequenceII subsequenceII = new A522_LongestUncommonSubsequenceII();
        int res = subsequenceII.findLUSlength(strs);
        System.out.println(res);
    }
}
