public class A33_SearchinRotatedSortedArray {

    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;

        int low = 0, high = nums.length - 1;
        while (low <= high){
            int mid = low + (high - low) / 2;

            if (nums[mid] == target)
                return mid;

            if (nums[mid] < nums[high]){
                if (nums[mid] < target && nums[high]>=target){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }else{
                if (nums[mid] > target && nums[low] <= target){
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        A33_SearchinRotatedSortedArray searchinRotatedSortedArray = new A33_SearchinRotatedSortedArray();
        int res = searchinRotatedSortedArray.search(nums, 0);
        System.out.println(res);
    }
}
