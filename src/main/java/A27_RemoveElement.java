public class A27_RemoveElement {
    public int removeElement(int[] nums, int val) {
        int res = 0;
        if(nums == null || nums.length == 0)
            return res;
        if(nums.length<2)
            return nums.length;

        int fast = 0;
        int slow = 0;
        while(fast<nums.length){
            if(nums[fast] == val){
                fast++;
            }else{
                if(fast == nums.length-1)
                    return slow;
                if(slow != fast){
                    nums[slow++] = nums[fast++];
                }
            }
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        A27_RemoveElement removeElement = new A27_RemoveElement();
        removeElement.removeElement(nums, 2);
    }

}
