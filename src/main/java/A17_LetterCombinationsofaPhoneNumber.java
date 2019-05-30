import java.util.ArrayList;
import java.util.List;

public class A17_LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        // 数字与字母的对应关系
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        if(digits.isEmpty())
            return res;
        // 图中树的根节点
        res.add("");

        // 遍历输入的数字
        for(char c : digits.toCharArray()){
            res = combine(map[c-'0'], res);
        }

        return res;
    }

    // 根据数字组合字母
    private List<String> combine(String digits, List<String> list){
        List<String> res = new ArrayList<>();

        for(char c : digits.toCharArray()){
            for(String s : list){
                res.add(s+c);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        A17_LetterCombinationsofaPhoneNumber phoneNumber = new A17_LetterCombinationsofaPhoneNumber();
        String digits = "23";
        List<String> res = phoneNumber.letterCombinations(digits);
        for (String s : res){
            System.out.print(s + " ");
        }
    }
}
