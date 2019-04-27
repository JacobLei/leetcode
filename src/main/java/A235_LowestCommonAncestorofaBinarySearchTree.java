public class A235_LowestCommonAncestorofaBinarySearchTree {
    /**
     *  递归实现
     *  如果根结点的值大于p和q之间的最大值，说明p和q都在左子树中，递归左子树
     *  如果根结点的值小于p和q之间的最小值，说明p和q都在右子树中，递归右子树
     *  当根结点的值在p和q的中间，返回此时的节点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return null;
        if(root.val > Math.max(p.val, q.val))
            return lowestCommonAncestor(root.left, p, q);
        if(root.val < Math.min(p.val, q.val))
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    // 非递归实现
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q)
    {
        while(root != null){
            if(root.val > Math.max(p.val, q.val))
                root = root.left;
            else if(root.val < Math.min(p.val, q.val))
                root = root.right;
            else
                break;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.creatBST();
        A235_LowestCommonAncestorofaBinarySearchTree lowestCommon =
                new A235_LowestCommonAncestorofaBinarySearchTree();

        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);

        System.out.println(lowestCommon.lowestCommonAncestor2(root, left, right).val);
    }
}
