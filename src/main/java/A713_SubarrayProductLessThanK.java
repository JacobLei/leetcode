import java.lang.reflect.Array;
import java.util.Arrays;

public class A713_SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0, mul = 1;
        for (int i = 0, j=0; j < nums.length; j++) {
            mul *= nums[j];
            while(i<=j && mul>=k){
                mul = mul / nums[i++];
            }
            res += j-i+1;
        }

        return res;
    }


    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        A713_SubarrayProductLessThanK productLess = new A713_SubarrayProductLessThanK();
        int res = productLess.numSubarrayProductLessThanK(nums, 100);
        System.out.println(res);
    }
}
