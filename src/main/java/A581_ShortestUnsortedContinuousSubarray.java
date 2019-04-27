public class A581_ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int begin = -1, end = -2, len = nums.length, min = nums[len-1], max = nums[0];

        for(int i=1; i<len; ++i){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[len-1-i]);
            if(nums[i]<max) end = i;
            if(nums[len-1-i]>min) begin = len-1-i ;
        }

        return end - begin + 1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        A581_ShortestUnsortedContinuousSubarray shortestUnsortedContinuousSubarray =
                new A581_ShortestUnsortedContinuousSubarray();

        int res = shortestUnsortedContinuousSubarray.findUnsortedSubarray(nums);
        System.out.println(res);
    }
}
