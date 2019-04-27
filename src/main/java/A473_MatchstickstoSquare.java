import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class A473_MatchstickstoSquare {

    public boolean makesquare(int[] nums){
        if(nums == null || nums.length < 4)
            return false;
        int sum = 0;
        for(int num : nums)
            sum += num;

        if(sum / 4 != 0)    // 如果sunm不为4的倍数，直接return false;
            return false;
        Arrays.sort(nums);
        reverse(nums);
        return dfs(nums, new int[4], 0, sum / 4);
    }

    private boolean dfs(int[] nums, int[] subsums, int index, int target) {
        if(index == nums.length){
            if(subsums[0] == target && subsums[1] == target && subsums[2] == target){   // 由于sum是4的倍数，因此只需要判断前三条边是否等于target，如果都等于，则第4条边也肯定也等于
                return true;
            }
            return false;
        }

        for(int i=0; i<4; ++i){
            if(subsums[i] + nums[index] > target){
                continue;
            }
            subsums[i] += nums[index];
            if(dfs(nums, subsums, index+1, target))
                return true;
            subsums[i] -= nums[index];  // subsums[i]恢复到递归前的状态
        }
        return false;
    }

    private void reverse(int[] nums){
        int i=0, j=nums.length-1;
        while(i<j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}
