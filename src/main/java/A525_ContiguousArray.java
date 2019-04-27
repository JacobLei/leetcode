import java.util.HashMap;
import java.util.Map;

public class A525_ContiguousArray {
    public int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0)
                nums[i] = -1;
        }

        Map<Integer, Integer> hashMap = new HashMap<>();    // <sum, pos>
        hashMap.put(0, -1);
        int sum = 0, max = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(hashMap.containsKey(sum)){
                max = Math.max(max, i-hashMap.get(sum));
            }else{
                hashMap.put(sum, i);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0};
        A525_ContiguousArray contiguousArray = new A525_ContiguousArray();
        int res = contiguousArray.findMaxLength(nums);
        System.out.println(res);
    }
}
