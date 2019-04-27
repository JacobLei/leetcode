import sun.plugin.javascript.navig.Link;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A15_3Sum {
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 3)
            return res;

        Arrays.sort(nums);

        for(int i=0; (i<nums.length-2) && nums[i] <= 0; ++i){      // nums.length-2的目的是最后两个数不需要计算
            if(i == 0 || nums[i] > nums[i-1]){    // 去掉重复固定的数，这里固定的数位nums[i]
                int start = i + 1;
                int end = nums.length - 1;

                while(start < end){
                    int stand = nums[i] + nums[start] + nums[end];
                    if(stand == 0){
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(nums[i]);
                        tmp.add(nums[start]);
                        tmp.add(nums[end]);
                        res.add(tmp);
                        start++;
                        end--;
                        // 去掉重复数
                        while(start<end && nums[start] == nums[start-1]){
                            start++;
                        }
                        while(start<end && nums[end] == nums[end-1]){
                            end--;
                        }
                    }else if(stand>0){
                        end--;
                    }else{
                        start++;
                    }
                }
            }
        }

        return res;
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
