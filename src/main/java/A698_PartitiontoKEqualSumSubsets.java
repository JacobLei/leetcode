import java.util.Arrays;

public class A698_PartitiontoKEqualSumSubsets {

    /**
     * 划分为K个相等的子集，递归+回溯
     * @param nums 已知数组
     * @param k     子集的个数
     * @return      判断是否可以划分成功
     */
    public boolean canPartitionKSubsets(int[] nums, int k){
        // 1. 求出所有nums数组中的和sums，如果sums%k != 0,则肯定不能达到要求
        int sums = sum(nums);
        if(sums % k != 0)
            return false;

        // 2. 求出目标数
        int target = sums / k;

        // 3. 给数组排序，判断数组中的最大值是否大于target，如果大于，则直接返回false
        Arrays.sort(nums);
        int beginIndex = nums.length - 1;
        if(nums[beginIndex] > target)
            return false;

        // 4. 判断数组中等于target的数，如果等于，直接向前移动即可，该数单独为一个子集
        while(beginIndex>=0 && nums[beginIndex] == target){
            beginIndex--;
            k--;
        }

        // 5. 调用递归函数
        return partition(new int[k], nums, beginIndex, target);
    }

    /**
     * 递归函数
     * @param subsets 子集合
     * @param nums 原数组
     * @param index 遍历的索引
     * @param target 目标函数
     * @return
     */
    private boolean partition(int[] subsets, int[] nums, int index, int target) {
        // 1. 当索引值index<0，则遍历完成
        if(index<0)
            return true;
        // 2. 选择数组中的值
        int selected = nums[index];
        // 3. 判断其是否可以和subsets中组合
        for (int i = 0; i < subsets.length; i++) {
            if(subsets[i] + selected <= target){
                subsets[i] += selected;
                // 如果可以组合，返回true
                if(partition(subsets, nums, index-1, target))
                    return true;
                // 如果不可以，回溯
                subsets[i] -= selected;
            }
        }
        return false;
    }

    private int sum(int[] nums) {
        int sum = 0;
        for(int num : nums)
            sum += num;
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        A698_PartitiontoKEqualSumSubsets equalSumSubsets = new A698_PartitiontoKEqualSumSubsets();
        System.out.println(equalSumSubsets.canPartitionKSubsets(nums, 4));

    }
}
