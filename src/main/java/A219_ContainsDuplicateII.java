import java.util.HashMap;

public class A219_ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(nums[i])){
                if((i-hashMap.get(nums[i])) <= k)
                    return true;
            }
            hashMap.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums= {1, 2, 3, 1};
        A219_ContainsDuplicateII containsDuplicate = new A219_ContainsDuplicateII();
        boolean res = containsDuplicate.containsNearbyDuplicate(nums, 3);
        System.out.println(res);
    }
}
