import java.util.HashMap;
import java.util.Map;

public class A567_PermutationinString {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if(len1>len2)
            return false;

        // 建立一个哈希表
        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        if(allZero(count)) return true;

        for(int i=len1; i<len2; i++){
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i-len1) - 'a']++;
            if(allZero(count)) return true;
        }

        return false;
    }

    private boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if(count[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        A567_PermutationinString permutationinString = new A567_PermutationinString();
        boolean res = permutationinString.checkInclusion(s1, s2);
        System.out.println(res);
    }
}
