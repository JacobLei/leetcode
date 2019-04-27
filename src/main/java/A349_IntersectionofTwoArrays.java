import java.util.*;

public class A349_IntersectionofTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> resMap = new HashMap<Integer, Integer>();
        for(int num : nums1){
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        for(int num : nums2){
            if(hashMap.containsKey(num) && hashMap.get(num)>0){
                resMap.put(num, resMap.getOrDefault(num, 0) + 1);
                hashMap.put(num, hashMap.get(num)-1);
            }
        }
        Collection<Integer> tmp = resMap.values();
        int len = 0;
        for(int i : tmp){
            len += i;
        }
        int[] res = new int[len];
        int pos = 0;
        for(int r : resMap.keySet()){
            int value = resMap.get(r);
            while(value != 0){
                res[pos++] = r;
                value--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
        A349_IntersectionofTwoArrays arrays = new A349_IntersectionofTwoArrays();
        int[] res = arrays.intersect(nums1, nums2);
        for (int i : res){
            System.out.println(i);
        }
    }
}
