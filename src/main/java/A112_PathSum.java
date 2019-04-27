public class A112_PathSum {
    /**
     *  DFS的典型应用
     */
    public boolean hasPathSum(TreeNode root, int sum){
        if(root == null)
            return false;
        if(root.left == null && root.right == null && root.val == sum){
            return true;
        }
        return hasPathSum(root.left, sum - root.val)
                || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree();
        A112_PathSum pathSum = new A112_PathSum();

        System.out.println(pathSum.hasPathSum(root, 8));

    }
}
