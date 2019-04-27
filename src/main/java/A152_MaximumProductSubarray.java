public class A152_MaximumProductSubarray {

    public int maxProduct(int[] nums) {

        int maxherepre = nums[0];
        int minherepre = nums[0];
        int maxsofar = nums[0];
        int maxhere;
        int minhere;

        for(int i=1; i<nums.length; ++i){
            maxhere = Math.max(Math.max(maxherepre*nums[i], minherepre*nums[i]), nums[i]);   // 在当前最大值与当前数的乘积，当前最小数与当前数的乘积，当前数这个三个数中选出最大值
            minhere = Math.max(Math.min(maxherepre*nums[i], minherepre*nums[i]), nums[i]);
            maxsofar = Math.max(maxsofar, maxhere);
            maxherepre = maxhere;
            minherepre = minhere;
        }
        return maxsofar;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, -2, 4};
        A152_MaximumProductSubarray maximumProductSubarray = new A152_MaximumProductSubarray();
        System.out.println(maximumProductSubarray.maxProduct(nums));


    }
}
