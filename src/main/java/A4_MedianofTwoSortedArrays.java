public class A4_MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (getKth(nums1, 0, nums2, 0, l) + getKth(nums1, 0, nums2, 0, r)) / 2.0;
    }

    // 在两个有序数组中二分查找第k大元素
    private int getKth(int[] nums1, int start1, int[] nums2, int start2, int k){
        // 特殊情况(1)，分析见正文部分
        if(start1 > nums1.length-1) return nums2[start2 + k - 1];
        if(start2 > nums2.length-1) return nums1[start1 + k - 1];
        // 特征情况(2)，分析见正文部分
        if(k == 1) return Math.min(nums1[start1], nums2[start2]);

        // 分别在两个数组中查找第k/2个元素，若存在（即数组没有越界），标记为找到的值；若不存在，标记为整数最大值
        int nums1Mid = start1 + k/2 - 1 < nums1.length ? nums1[start1 + k/2 - 1] : Integer.MAX_VALUE;
        int nums2Mid = start2 + k/2 - 1 < nums2.length ? nums2[start2 + k/2 - 1] : Integer.MAX_VALUE;

        // 确定最终的第k/2个元素，然后递归查找
        if(nums1Mid < nums2Mid)
            return getKth(nums1, start1 + k/2, nums2, start2, k-k/2);
        else
            return getKth(nums1, start1, nums2, start2 + k/2, k-k/2);
    }
}
