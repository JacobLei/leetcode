public class A26_RemoveDuplicatesfromSortedArray {

    public int removeDuplicates(int[] nums) {
        if(nums == null)
            return 0;

        int res = 1;

        if(nums.length < 2)
            return res;

        int slow = 0;
        int fast = 1;

        while(slow < fast && fast < nums.length){

            // 当出现重复项的时候，移动fast指针
            while(nums[slow] == nums[fast]){
                fast++;
                if(fast == nums.length)
                    return res;
            }

            // 当不是重复项是，原地删除重复项（即将后面的数移动到前面来）
            // ++slow;
            // nums[slow] = nums[fast];
            // fast++;
            // 可以写出下面的表达形式，这里注意++i与i++的区别
            nums[++slow] = nums[fast++];

            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        A26_RemoveDuplicatesfromSortedArray removeDuplicatesfromSortedArray = new A26_RemoveDuplicatesfromSortedArray();
        int[] nums = {1, 1, 2};
        int res = removeDuplicatesfromSortedArray.removeDuplicates(nums);
        System.out.println(res);
    }
}
