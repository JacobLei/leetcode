import java.util.Stack;

public class A402_RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if(num.length() <= k)
            return "0";

        Stack<Character> stack = new Stack<Character>();
        String ret = "";
        int i=0;
        int len = num.length();
        for(; i<len; ++i){
            char c = num.charAt(i);
            while(!stack.isEmpty() && k > 0 && stack.peek() > c){
                stack.pop();
                k--;
            }
            if(!stack.isEmpty() || c != '0')
                stack.push(c);
        }

        while(k>0){
            stack.pop();
            k--;
        }

        if(stack.isEmpty() && (i == len ))
            return "0";
        ret = num.substring(i);
        while(!stack.isEmpty())
            ret = stack.pop() + ret;

        return ret;
    }
}
