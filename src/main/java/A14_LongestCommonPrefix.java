import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class A14_LongestCommonPrefix {

    public String longestCommonPrefix_1(String[] strs) {
        StringBuilder res = new StringBuilder();

        if(strs == null || strs.length == 0 )
            return  res.toString();

        for (int col = 0; col < strs[0].length(); col++){
            // 第0行的第col个字符
            char c = strs[0].charAt(col);

            // 基准字符串中的字符与其他字符串中的字符进行对比
            for(int row = 1; row < strs.length; row++){
                if(col >= strs[row].length() || strs[row].charAt(col) != c)
                    return  res.toString();
            }

            res.append(c);
        }

        return res.toString();
    }

    public String longestCommonPrefix_2(String[] strs) {
        StringBuilder res = new StringBuilder();

        if(strs == null || strs.length == 0 )
            return  res.toString();

        // 将字符串数组排序
        Arrays.sort(strs);

        // 取数组中的首尾字符串，并将其转为字符数组
        char[] firstRow = strs[0].toCharArray();
        char[] lastRow = strs[strs.length-1].toCharArray();

        // 查找公共前缀时只需要查找最短长度的字符串
        int len = firstRow.length < lastRow.length ? firstRow.length : lastRow.length;

        // 比较首位两个字符串，取最长公共前缀
        for(int i=0; i<len; i++){
            if(firstRow[i] != lastRow[i])
                return res.toString();
            res.append(firstRow[i]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String[] str = {"flower","flow","flight"};
        A14_LongestCommonPrefix longestCommonPrefix = new A14_LongestCommonPrefix();

        String res1 = longestCommonPrefix.longestCommonPrefix_1(str);
        String res2 = longestCommonPrefix.longestCommonPrefix_2(str);

        System.out.println(res1);
        System.out.println(res2);

    }
}
