public class A114_FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root){
        if(root == null)
            return ;
        TreeNode left = root.left;      // 保存左结点信息
        TreeNode right = root.right;    // 保存又结点信息
        flatten(left);                  // 递归调用
        flatten(right);

        // 构造扁平树
        root.left = null;               //令该左结点为空
        root.right = left;              // 根结点的又结点为左结点
        TreeNode cur = root;
        while(cur.right != null){       // 根结点的右结点为所有右结点的右结点
            cur = cur.right;
        }
        cur.right = right;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree();
        A114_FlattenBinaryTreetoLinkedList flattenBinary = new A114_FlattenBinaryTreetoLinkedList();

        flattenBinary.flatten(root);
        TreeNode.printTree(root);
    }
}
