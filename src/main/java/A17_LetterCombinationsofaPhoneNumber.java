import java.util.ArrayList;
import java.util.List;

public class A17_LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.isEmpty())
            return res;
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            res = combine(map[digits.charAt(i) - '0'], res);
        }

        return res;
    }

    private List<String> combine(String digit, List<String> list) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < digit.length(); i++) {
            for (String s : list){
                res.add(s+digit.charAt(i));
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
