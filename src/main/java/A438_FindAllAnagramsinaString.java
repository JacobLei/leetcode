import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class A438_FindAllAnagramsinaString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null)
            return res;
        int left = 0, right = 0, count = p.length();
        char[] sc = s.toCharArray();
        // 构建p的hashMap
        int[] map = new int[256];
        for (char c : p.toCharArray())
            map[c]++;
        while (right < s.length()) {
            // 每次right读到一个字符char，都有hashMap[char]--,
            // 当map[char]的值大于等于1时，就是窗户进入了一个p中包含的字符。
            // 取一个变量count，值为p中所有字符的总数。
            // 每次有一个p中字符进入窗口，则count--
            if (map[sc[right++]]-- >= 1)
                count--;
            // 当count==0时，窗口中包含p中的全部字符
            if (count == 0)
                res.add(left);
            // 当窗口包含一个结果以后，为了进一步遍历，
            // 需要缩小窗口使得窗口不再包含全部的p，
            // 同样，如果map[char]>=0,则表明一个在p中的字符就要移除窗口，
            // 那么count++。
            // 这里最巧妙的一点是先判断right-left == p.length,
            // 如果这个等式不满足，则后面的就没有参与运算
            if (right - left == p.length() && map[sc[left++]]++ >= 0)
                count++;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        A438_FindAllAnagramsinaString strings = new A438_FindAllAnagramsinaString();
        List<Integer> res = strings.findAnagrams(s, p);
        for(int i : res){
            System.out.println(i);
        }

    }
}
