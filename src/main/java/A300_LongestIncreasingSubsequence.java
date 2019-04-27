import java.util.Arrays;

public class A300_LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums){
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums){
            int i = Arrays.binarySearch(dp, 0, len, x) > 0
                    ? Arrays.binarySearch(dp, 0, len, x)
                    : -(Arrays.binarySearch(dp, 0, len, x)+1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }

    public static void main(String[] args) {
        A300_LongestIncreasingSubsequence longestIncreasingSubsequence = new A300_LongestIncreasingSubsequence();
        int[] nums = {10,9,2,5,3,7,101,18};
        int res = longestIncreasingSubsequence.lengthOfLIS(nums);
        System.out.println(res);
    }
}
