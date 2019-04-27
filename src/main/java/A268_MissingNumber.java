public class A268_MissingNumber {

    public int missingNumber(int[] nums){
        int sum = 0;
        int len = nums.length;
        for(int num : nums){
            sum += num;
        }

        return (len * (len+1)) / 2 - sum;
    }

    public int missingNumber2(int[] nums){
        int ret = 0;

        for(int i=0; i<nums.length; ++i){
            ret ^= (i+1) ^ nums[i];
        }

        return ret;
    }

    public static void main(String[] args) {
        A268_MissingNumber missingNumber = new A268_MissingNumber();
        int[] nums = {3, 0, 1};
        System.out.println(missingNumber.missingNumber2(nums));
    }

}
