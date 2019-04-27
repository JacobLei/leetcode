import java.util.HashMap;
import java.util.Map;

public class A697_DegreeofanArray {

    /**
     * 查找子数组的度和原数组的度相同的最小子数组
     * @param nums
     * @return
     */
    public int findShortesSubArray(int[] nums){
        if(nums == null || nums.length == 0)
            return 0;
        // 构建HashMap,key为nums[i], value为int[]{degree, i, i},其中数组的第一个元素代表数组的该元素值出现的次数，第一个值为第一次出现的位置，第三个值为最后一次出现的位置
        Map<Integer, int[]> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!hashMap.containsKey(nums[i])){  // 如果没有key
                hashMap.put(nums[i], new int[]{1, i, i});   // 初始化
            }else{                              // 更新
                int[] tmp = hashMap.get(nums[i]);
                tmp[0]++;
                tmp[2] = i;
            }
        }

        int degree = Integer.MIN_VALUE, res = Integer.MAX_VALUE;
        for (int[] value : hashMap.values()) {
            if(value[0] > degree){
                degree = value[0];
                res = value[2] - value[1]+1;
            }else if(value[0] == degree ){
                res = Math.min(res, value[2]- value[1]+1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 1};
        A697_DegreeofanArray degreeofanArray = new A697_DegreeofanArray();
        int res = degreeofanArray.findShortesSubArray(nums);
        System.out.println(res);
    }
}
