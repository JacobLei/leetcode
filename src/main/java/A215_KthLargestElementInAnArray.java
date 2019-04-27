import java.util.PriorityQueue;

public class A215_KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k){
        int left = 0, right = nums.length-1;

        while(true){
            int pos = partition(nums, left, right);
            if(pos == k-1)
                return nums[pos];
            else if(pos >k-1)
                right = pos - 1;
            else
                left = pos + 1;
        }
    }

    // 从大到小排序
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left], l = left + 1, r = right;
        while(l <= r){
            if(nums[l]<pivot && pivot<nums[r]){     //num[l] < pivot < num[r]
                swap(nums, l++, r--);
            }
            if(nums[l]>=pivot) l++;
            if (nums[r]<=pivot) r--;
        }
        swap(nums, left, r);
        return r;
    }

    private void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    public static void main(String[] args) {
       int[] nums = {3,2,1,5,6,4};
       A215_KthLargestElementInAnArray elementInAnArray = new A215_KthLargestElementInAnArray();
        System.out.println(elementInAnArray.findKthLargest(nums, 2));
    }

}
