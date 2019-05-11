import java.util.HashMap;

public class A3_LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        if(s.length() == 0)
            return res;
        // 创建HashMap，用来保存字符与位置之间的对应关系
        HashMap<Character, Integer> hashMap = new HashMap<>();
        // 初始化左指针和右指针，并遍历字符串
        for(int left = 0, right = 0; right < s.length(); right++){
            // 判断右指针指向的字符是否出现过
            if(hashMap.containsKey(s.charAt(right))){
                // 如果出现过，获取左指针的位置
                left = Math.max(left, hashMap.get(s.charAt(right))+1);
            }
            // 对于第一次出现的字符，保存该字符的位置；对于多次出现的字符，更新该字符出现的位置
            hashMap.put(s.charAt(right), right);
            // 更新窗口的大小，保存最大的窗口大小
            res = Math.max(res, right-left+1);
        }
        return res;
    }


}
