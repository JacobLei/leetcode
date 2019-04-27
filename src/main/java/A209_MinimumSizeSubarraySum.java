public class A209_MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0 || (nums[0] < s && nums.length < 2))
            return 0;
        if(nums[0] >= s)
            return 1;
        int left = 0, right = 0;
        int res = nums.length + 1;
        int len = nums.length;
        int sum = 0;
        while(right < len){
            while(sum < s && right < len){
                sum += nums[right++];
            }
            while(sum>=s){
                res = Math.min(res, right-left);
                sum -= nums[left++];
            }
        }

        return res == len+1 ?  0 : res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        A209_MinimumSizeSubarraySum minimumSizeSubarraySum = new A209_MinimumSizeSubarraySum();
        System.out.println(minimumSizeSubarraySum.minSubArrayLen(7, nums));

    }
}
