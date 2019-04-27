public class A108_ConvertSortedArraytoBinarySearchTree {
    // 根据二分法来创建平衡二叉树
    public TreeNode sortedArrayToBST(int[] nums){
        if(nums == null || nums.length == 0)
            return null;
        return getBST(nums, 0, nums.length-1);
    }

    private TreeNode getBST(int[] nums, int l, int r) {
        if(l>r)
            return null;
        int mid = (l + r) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = getBST(nums, l, mid-1);
        node.right = getBST(nums, mid+1, r);
        return node;
    }

    public static void main(String[] args) {
        int[] nums = {1,2, 3, 4, 5, 6};
        A108_ConvertSortedArraytoBinarySearchTree convertSorted =
                new A108_ConvertSortedArraytoBinarySearchTree();

        TreeNode result = convertSorted.sortedArrayToBST(nums);

        TreeNode.printTree(result);
    }
}
