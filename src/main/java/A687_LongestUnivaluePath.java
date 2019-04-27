public class A687_LongestUnivaluePath {
    public int longestUnivaluePath(TreeNode root){
        int ret = 0;
        if(root == null)
            return ret;
        dfs(root, root, ret);
        return ret;
    }

    private int dfs(TreeNode node, TreeNode parent, int ret) {
        if(node == null)
            return 0;
        int left = dfs(node.left, node, ret);
        int right = dfs(node.right, node, ret);
        left = (node.left != null && (node.val == node.left.val) ? left + 1 : 0);
        right = (node.right != null && (node.val == node.right.val) ? right + 1 : 0);
        ret = Math.max(ret, left+right);
        return Math.max(left, right);
    }
}
