public class A494_TargetSum {
    int ret = 0;

    public int findTargetSumWays(int[] nums, int s){
        if(nums == null || nums.length == 0)
            return ret;
        dfs(nums, s, 0);
        return ret;
    }

    private void dfs(int[] nums, int sum, int index) {
        if(index == nums.length){
            if(sum == 0){
                ret++;
            }
            return ;
        }

        dfs(nums, sum+nums[index], index+1);
        dfs(nums, sum-nums[index], index+1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        A494_TargetSum  targetSum = new A494_TargetSum();
        System.out.println(targetSum.findTargetSumWays(nums, 3));
    }

}
