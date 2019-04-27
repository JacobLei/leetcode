import java.util.Arrays;

public class A16_3SumClosest {
    public int threeSumClosest(int[] nums, int target){
        int colse = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;

        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; ++i){
            int left = i+1;
            int right = nums.length - 1;
            while(left < right){
                int tmp = nums[i] + nums[left] + nums[right] - target;
                if(Math.abs(tmp) < diff){
                    diff = Math.abs(tmp);
                    colse = tmp+target;
                }
                if(tmp>0){
                    right--;
                }else{
                    left++;
                }
            }
        }

        return colse;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        A16_3SumClosest sumClosest = new A16_3SumClosest();
        System.out.println(sumClosest.threeSumClosest(nums, 1));
    }
}
