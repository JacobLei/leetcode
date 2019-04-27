public class A287_FindtheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        // 借组数组的坐标来判断
        int left = 0, right = nums.length-1;

        while(left<right){
            int mid  = left + (right - left) / 2;
            int cnt = 0;
            for(int num : nums){
                if(num <= mid){
                    cnt++;
                }
            }
            if(cnt <= mid){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};

        A287_FindtheDuplicateNumber findtheDuplicateNumber = new A287_FindtheDuplicateNumber();
        System.out.println(findtheDuplicateNumber.findDuplicate(nums));
    }
}
