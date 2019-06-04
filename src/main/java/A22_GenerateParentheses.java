import java.util.ArrayList;
import java.util.List;

public class A22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        helper(n, n, "", res);
        return res;
    }

    // 递归辅助函数
    private void helper(int left, int right, String out, List<String> res){
        // 递归终止条件
        if (left < 0 || right < 0 || left > right)
            return ;
        // 当left和right都为0时，保存有效的括号组
        if(left == 0 && right == 0){
            res.add(out);
            return ;
        }

        // 减小问题的规模
        helper(left-1, right, out + "(", res);
        helper(left, right-1, out + ")",res);
    }

    public static void main(String[] args) {
        A22_GenerateParentheses generateParentheses = new A22_GenerateParentheses();
        List<String> res = generateParentheses.generateParenthesis(3);
        System.out.println(res);
    }

}
