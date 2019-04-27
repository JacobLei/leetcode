public class A563_BinaryTreeTilt {
    /**
     *  求二叉树的坡度。
     *  先找到左子树和右子树的和，再计算tilt，即可使用后序遍历。
     */
    public int ret = 0;
    public int findTilt(TreeNode root){
        if(root == null)
            return ret;
        getSum(root);
        return ret;
    }

    private int getSum(TreeNode node) {
        if(node == null)
            return 0;
        int sumLeft = getSum(node.left);
        int sumRight = getSum(node.right);
        ret += Math.abs(sumLeft - sumRight);
        return sumLeft + sumRight + node.val;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree();
        A563_BinaryTreeTilt binaryTreeTilt = new A563_BinaryTreeTilt();
        System.out.println(binaryTreeTilt.findTilt(root));
    }
}
