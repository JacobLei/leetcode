import java.util.HashMap;
import java.util.Map;

public class A659_SplitArrayIntoConsecutiveSubsequences {
    /*
    *   freq: 保存数组元素对应的个数
    *   appendFreq: 用来判断当前元素是否能够插入到一个已经构建好的序列末端
    *
    *   遍历nums，判断一个元素是否能够插入一个已经构建好的序列末端，
    *   或者是否能够作为新序列的起点，
    *   如果两者都不可以，返回false
    */
    public boolean isPossible(int[] nums){
        boolean ret = true;
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> appendFreq = new HashMap<>();

        // 统计每个数字出现的频率
        for(int i : nums )
            freq.put(i, freq.getOrDefault(i, 0)+1);

        // 遍历数组，按照规则判断序列是否连续
        for(int num : nums){
            // 当前元素个数为0时，continue
            if(freq.get(num) == 0){
                continue;
            }
            // 当元素个数大于0时，判断appendFre是否大于零
            else if(appendFreq.getOrDefault(num, 0)>0){
                appendFreq.put(num, appendFreq.get(num)-1);
                appendFreq.put(num+1,
                        appendFreq.getOrDefault(num+1, 0) + 1);
            }
            // 当元素个数大于0时，且appendFre为零时,
            // 作为新序列的第一个元素，保重这个元素最少有三个连续的元素
            // 维护freq中元素的个数
            else if(freq.getOrDefault(num+1, 0) > 0
                    && freq.getOrDefault(num+2, 0) > 0){
                freq.put(num+1, freq.get(num+1)-1);
                freq.put(num+2, freq.get(num+2)-1);
                appendFreq.put(num+3, appendFreq.getOrDefault(num+3, 0)+1);
            }
            else{
                return false;
            }
            freq.put(num, freq.get(num)-1);

        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,3,4,5};
        int[] nums2 = {1,2,3,4,4,5};
        A659_SplitArrayIntoConsecutiveSubsequences splitArray =
                new A659_SplitArrayIntoConsecutiveSubsequences();
        System.out.println(splitArray.isPossible(nums2));
    }
}
