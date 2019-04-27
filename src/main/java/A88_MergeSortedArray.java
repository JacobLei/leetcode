public class A88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int end1 = m-1, end2 = n-1, end3 = (m+n-1);

        while(end1 >= 0 && end2 >= 0){
            if(nums1[end1]>=nums2[end2])
                nums1[end3--] = nums1[end1--];
            else
                nums1[end3--] = nums2[end2--];
        }

        while(end1>=0) nums1[end3--] = nums1[end1--];
        while(end2>=0) nums1[end3--] = nums2[end2--];
    }

    public static void main(String[] args) {
//        int[] nums1 = {0};
//        int[] nums2 = {2};

        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int[] nums2 = {1, 2, 3};

        A88_MergeSortedArray mergeSortedArray = new A88_MergeSortedArray();
        mergeSortedArray.merge(nums1, 3, nums2, 3);
        for (int i : nums1 ) {
            System.out.print(i);
        }
    }
}
