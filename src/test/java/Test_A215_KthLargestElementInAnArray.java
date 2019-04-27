public class Test_A215_KthLargestElementInAnArray {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;

        A215_KthLargestElementInAnArray kthLargest = new A215_KthLargestElementInAnArray();

        System.out.println(kthLargest.findKthLargest(nums, k));
    }
}
