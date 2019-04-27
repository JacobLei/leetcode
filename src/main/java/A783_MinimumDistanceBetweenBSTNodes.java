public class A783_MinimumDistanceBetweenBSTNodes {

    Integer res;
    Integer pre;

    public int minDiffInBST(TreeNode root){
        res = Integer.MIN_VALUE;
        pre = null;
        inorder(root);
        return res;
    }

    private void inorder(TreeNode node) {
        if(node == null)
            return ;
        inorder(node.left);
        if (pre != null) {
            res = Math.min(res, node.val - pre);
        }
        inorder(node.right);
    }
}
