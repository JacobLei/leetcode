public class A110_BalancedBinaryTree {
    /**
     * 判断是否为平衡二叉树，即求树的深度，如果有两个两个节点的深度之差大于1，
     * 则不为平衡二叉树。
     */
    public boolean isBalanced(TreeNode root){
        if(root == null)
            return true;
        if(Math.abs(getDepth(root.left) - getDepth(root.right))>1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getDepth(TreeNode node) {
        if(node==null)
            return 0;
        return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree();
        A110_BalancedBinaryTree balancedBinaryTree = new A110_BalancedBinaryTree();

        System.out.println(balancedBinaryTree.isBalanced(root));
    }
}
