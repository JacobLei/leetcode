import java.util.TreeSet;

public class A220_ContainsDuplicateIII {

    /**
     * 使用TreeSet(二叉搜索树)来在一定范围进行检查
     * @param nums 数组元素
     * @param k 范围区域（在k个元素范围内）
     * @param t 元素差
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t){
        if(nums == null || nums.length == 0 || k <=0 )
            return false;

        TreeSet<Long> value = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
//            long num = nums[i];
            Long floor = value.floor((long)(nums[i]) + t);   // 在TreeSet中返回小于等于num[i]+t的最大元素值，如果没有，则返回null
            Long ceil = value.ceiling((long)(nums[i]) - t);  // 在TreeSet中返回大于等于num[i]it的最小元素值，如果没有，则返回null

            if(((floor != null) && (floor >= nums[i])) || ((ceil != null) && (ceil <= nums[i]))) {
                return true;
            }

            value.add((long)nums[i]);
            if(i>=k){
                value.remove((long)nums[i-k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {-2147483648, -2147483647};
        int k = 3;
        int t = 3;
        A220_ContainsDuplicateIII containsDuplicate = new A220_ContainsDuplicateIII();
        System.out.println(containsDuplicate.containsNearbyAlmostDuplicate(nums, k, t));
    }

}
