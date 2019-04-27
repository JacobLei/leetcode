import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if(nums == null || nums.length<4)
            return res;
        Arrays.sort(nums);

        for(int i=0; i<nums.length-3; ++i){
            if(i != 0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1; j<nums.length-2; ++j){
                if((j != i+1) && (nums[j] == nums[j-1])) continue;
                int left = j+1,right = nums.length-1;

                while(left<right){
                    int tmp = nums[i] + nums[j] + nums[left] + nums[right];
                    if(tmp == target){
                        ArrayList<Integer> a = new ArrayList<>();
                        a.add(nums[i]);
                        a.add(nums[j]);
                        a.add(nums[left]);
                        a.add(nums[right]);
                        res.add(a);
                        left++;
                        right--;
                        while(left<right && nums[left] == nums[left-1])
                            left++;
                        while(left<right && nums[right] == nums[right+1])
                            right--;
                    }else if(tmp > target)
                        right--;
                    else
                        left++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0};
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
