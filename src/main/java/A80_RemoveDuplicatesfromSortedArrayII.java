public class A80_RemoveDuplicatesfromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len<3)
            return len;

        int pre = 0, cur = 1, cnt = 1;

        while(cur < len){
            if(nums[cur] == nums[pre] && cnt == 0) cur++;
            else{
                if(nums[pre] == nums[cur])
                    --cnt;
                else
                    cnt = 1;
                nums[++pre] = nums[cur++];
            }
        }

        return pre+1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        A80_RemoveDuplicatesfromSortedArrayII removeDuplicates =
                new A80_RemoveDuplicatesfromSortedArrayII();
        int len = removeDuplicates.removeDuplicates(nums);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}
