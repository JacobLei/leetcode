import java.util.Stack;

public class A456_132Pattern {

    public boolean find132pattern(int[] nums){
        int third = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<Integer>();

        for(int i= nums.length-1; i>=0; --i){
            int num = nums[i];
            if (num<third)
                return true;
            else{
                while(!stack.isEmpty() && stack.peek()<num){
                    third = stack.pop();
                }
                stack.push(num);
            }
        }
        return false;
    }
}
