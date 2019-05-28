import sun.plugin.javascript.navig.Link;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A15_3Sum {

    // 存储满足条件的三元组
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums){

        if(nums == null || nums.length < 3)
            return res;
        // 给数组排序
        Arrays.sort(nums);

        int len = nums.length;

        // 注意遍历的右边界条件
        for (int i=0; i<len-2; i++){
            // 去掉重复值
            if (i > 0 && nums[i] == nums[i-1])
                continue;

            // 由于数组已排序，当nums[i]>0,则它后面的数都大于零，不需要继续查找
            if (nums[i] > 0)
                break;
            // 在数组中查找两个数与nums[i]的和为0
            find(nums, i+1, len-1, nums[i]);
        }

        return res;
    }

    // 查找函数
    private void find(int[] nums, int begin, int end, int target){
        int left = begin, right = end;
        while (left < right){
            // 查找满足条件的三个
            if(nums[left] + nums[right] + target == 0){
                // 保存这个三个数
                List<Integer> tmp = new ArrayList<>();
                tmp.add(target);
                tmp.add(nums[left]);
                tmp.add(nums[right]);
                res.add(tmp);

                // 去掉重复的值
                while (left < right && nums[left] == nums[left+1])
                    left++;
                while (left < right && nums[right] == nums[right-1])
                    right--;

                // 移动左右指针
                left++;
                right--;
            }else if(nums[left] + nums[right] + target < 0){    // 当这个三个之和小于0，则左指针向右移动
                left++;
            }else { // 当这三个数大于零，则右指针向左移动
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        A15_3Sum sum = new A15_3Sum();
        List<List<Integer>> res = sum.threeSum(nums);
        for(List<Integer> list : res){
            for(Integer i : list){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
