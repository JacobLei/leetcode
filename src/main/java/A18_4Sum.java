import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null && nums.length < 4)
            return res;

        // 对数组排序
        Arrays.sort(nums);

        // 固定第一个数
        for(int i=0; i<nums.length-3; ++i){

            if(i!=0 && nums[i] == nums[i-1])
                continue;

            if(nums[i+1]>0 && nums[i] >= target)
                return res;
            // 固定第二个数
            for(int j=i+1; j<nums.length-2; ++j){
                if((j != i + 1) && nums[j] == nums[j-1])
                    continue;

                // 使用左右指针进行查找
                int left = j+1, right = nums.length-1;
                while(left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target){
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[left]);
                        tmp.add(nums[right]);
                        res.add(tmp);
                        ++left;
                        --right;
                        while(left<right && nums[left] == nums[left-1])
                            ++left;
                        while(left<right && nums[right] == nums[right+1])
                            --right;
                    }else if(sum > target)
                        --right;
                    else
                        ++left;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        A18_4Sum sum = new A18_4Sum();
        List<List<Integer>> res = sum.fourSum(nums, 0);
        for(List<Integer> list : res){
            for(Integer i : list){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
