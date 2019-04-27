public class A643_MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        double sum = 0.0;
        for(int i=0; i<k; i++){
            sum += nums[i];
        }
        double res = sum/k;
        for(int i=k; i<len; i++){
            sum = sum + nums[i] - nums[i-k];
            res = Math.max(res, sum/k);
        }

        return res;
    }

    public static void main(String[] args) {
        A643_MaximumAverageSubarrayI subarray = new A643_MaximumAverageSubarrayI();
        int[] nums = {-1};
        double res = subarray.findMaxAverage(nums, 1);

        System.out.println(res);
    }
}
