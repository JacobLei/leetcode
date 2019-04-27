import java.util.Stack;

public class A150_EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens){
        Stack<Integer> stack = new Stack<Integer>();
        for(String token : tokens){
            if(!token.equals("+") && !token.equals("-")
                    && !token.equals("*") && !token.equals("/")) {
                stack.push(Integer.parseInt(token));
            }else{
                int right = stack.pop();
                int left = stack.pop();
                switch (token.charAt(0)){
                    case '+':
                        stack.push(left + right);
                        break;
                    case '-':
                        stack.push(left - right);
                        break;
                    case '*':
                        stack.push(left * right);
                        break;
                    case '/':
                        stack.push(left / right);
                        break;
                }
            }
        }
        return stack.peek();
    }
}
