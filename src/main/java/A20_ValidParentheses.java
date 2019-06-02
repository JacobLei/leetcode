import java.util.Stack;

public class A20_ValidParentheses {

    public boolean isValid(String s) {
        // 申请栈
        Stack<Character> stack = new Stack<>();

        // 将字符串转化为字符数组
        char[] chars = s.toCharArray();

        for (int i=0; i<chars.length; i++){
            // 判断当前字符是否为 '(' 、'[' 或 '{'
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{'){
                // 如果时，则入栈
                stack.push(chars[i]);
            }else{
                // 如果不是，则为')'、']'或'}''，判断栈中是否有对应的左括号
                if (stack.empty()){
                    return false;
                }else{
                    char c = stack.pop();
                    if ((chars[i] == ')' && c != '(') || (chars[i] == ']' && c != '[') || (chars[i] == '}' && c != '{')){
                        return false;
                    }
                }
            }
        }

        // 只有当栈为空时，才为true
        return stack.empty() ? true : false;

    }

    public static void main(String[] args) {
        A20_ValidParentheses validParentheses = new A20_ValidParentheses();
        boolean res = validParentheses.isValid("{[]}");
        System.out.println(res);
    }
}
