import java.util.Stack;

/**
 * 思路：初始符号位为+，然后判断下一个符号位
 *      如果下一个符号位为+，将数字入栈，
 *      如果下一个符号位为-，将数字的相反数入栈，
 *      如果下一个符号位为*，将栈顶元素与当前数字相乘的结果入栈，
 *      如果下一个符号位为/，将栈顶元素与当前数字相除的结果入栈。
 *      最后将栈中的数字相加。
 */
public class A227_BasicCalculatorII {
    public int calculate(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int len = 0, num = 0, res = 0;
        Stack<Integer> stack = new Stack<>();
        char sign = '+';

        for(int i=0; i<len; i++){
            if(Character.isDigit(s.charAt(i)))
                num = num*10 + (s.charAt(i)-'0');
            System.out.println(num);
            if((!Character.isDigit(s.charAt(i)) && s.charAt(i)!=' ') || (i == len-1)){
                if(sign == '+')
                    stack.push(num);
                if(sign == '-')
                    stack.push(-num);
                if(sign == '*')
                    stack.push(stack.pop()*num);
                if(sign == '/')
                    stack.push(stack.pop()/num);

                sign = s.charAt(i);
                num = 0;
            }
        }

        for(int i : stack)
            res += i;

        return res;
    }

    public static void main(String[] args) {
        String s = " 3+5 / 2 ";
        A227_BasicCalculatorII basicCalculatorII = new A227_BasicCalculatorII();
        int res = basicCalculatorII.calculate(s);
        System.out.println(res);
    }
}
