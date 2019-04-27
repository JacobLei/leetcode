public class A560_SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        if(nums == null || nums.length<2)
            return res;
        int left = 0, right = 1;
        int sum = nums[left];
        while(right < nums.length){

            while(right < nums.length && sum < k){
                sum += nums[right];
                right++;
            }
            if(sum == k){
                res++;
            }
            sum -= nums[left];
            left++;

        }

        return res;
    }

    public static void main(String[] args) {
        A560_SubarraySumEqualsK subarraySumEqualsK = new A560_SubarraySumEqualsK();
        int[] nums = {1, 1, 1};

        int res = subarraySumEqualsK.subarraySum(nums, 2);
        System.out.println(res);
    }
}
