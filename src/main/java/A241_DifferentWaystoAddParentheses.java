import org.omg.PortableInterceptor.INACTIVE;

import java.util.LinkedList;
import java.util.List;

public class A241_DifferentWaystoAddParentheses {
    public List<Integer> diffWaysToCompute(String input){
        List<Integer> res = new LinkedList<>();

        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*'){
                String left = input.substring(0, i);
                String right = input.substring(i+1);
                List<Integer> leftRet = diffWaysToCompute(left);
                List<Integer> rightRet = diffWaysToCompute(right);

                for (Integer l : leftRet){
                    for(Integer r : rightRet){
                        int c = 0;
                        switch (input.charAt(i)){
                            case '+':
                                c = l + r;
                                break;
                            case '-':
                                c = l - r;
                                break;
                            case '*':
                                c = l * r;
                                break;
                        }
                        res.add(c);
                    }
                }
            }
        }
        if(res.size() == 0)
            res.add(Integer.valueOf(input));

        return res;
    }

    public static void main(String[] args) {
        A241_DifferentWaystoAddParentheses addParentheses = new A241_DifferentWaystoAddParentheses();
        List<Integer> res = addParentheses.diffWaysToCompute("2*3-4*5");

        for(Integer i : res){
            System.out.println(i);
        }
    }
}
