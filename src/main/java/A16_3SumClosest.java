import java.util.Arrays;

public class A16_3SumClosest {

    public int threeSumClosest(int[] nums, int target) {

        int sum =0;    // 表示数组中三个元素的和
        int dis = Integer.MAX_VALUE;   // 表示数组中三个元素的和与target的距离，即|sum-target|

        // 对数组进行排序
        Arrays.sort(nums);
        // 遍历数组
        for(int i=0; i<nums.length-2; ++i){
            // 定义左指针和右指针
            int left = i+1, right = nums.length-1;

            while(left<right){
                // 数组中三个元素的和与target的差，即sum-target
                int diff = nums[i] + nums[left] + nums[right] - target;

                // 当sum-target == 0，则说明已经找到与target最近的数了（即target本身）
                if (diff == 0)
                    return target;

                // 寻找最小距离
                if(Math.abs(diff) < dis){
                    dis = Math.abs(diff);
                    sum = diff + target;
                }

                // 移动左右指针
                if(diff > 0){
                    --right;
                }else{
                    ++left;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        A16_3SumClosest sumClosest = new A16_3SumClosest();
        System.out.println(sumClosest.threeSumClosest(nums, 1));
    }
}
