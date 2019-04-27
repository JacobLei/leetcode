public class A565_ArrayNesting {
    public int arrayNesting(int[] nums) {
        int maxsize = 0;

        for (int i = 0; i < nums.length; i++) {
            int size = 0;
            for (int j = i; nums[j] >= 0; size++) {
                int index = nums[j];
                nums[j] = -1;       // 标记达到的数字为-1，下次遇到这个数时，就会退出循环
                j = index;
            }

            maxsize = Math.max(maxsize, size);
        }

        return maxsize;
    }

    public static void main(String[] args) {
        A565_ArrayNesting arrayNesting = new A565_ArrayNesting();
        int[] nums = {5, 4, 0, 3, 1, 6, 2};
        int res = arrayNesting.arrayNesting(nums);
        System.out.println(res);
    }
}
