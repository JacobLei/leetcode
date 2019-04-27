import java.util.LinkedList;
import java.util.Queue;

public class A226_InvertBinaryTree {
    /**
     *  递归解法
     */
    public TreeNode invertTree(TreeNode root){
        if(root == null)
            return null;
        TreeNode node = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(node);
        return root;
    }

    /**
     * 非递归方法
     * 借组Queue来实现
     */
    public TreeNode invertTree2(TreeNode root){
        if(root == null)
            return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if(node.left != null)
                q.offer(node.left);
            if(node.right != null)
                q.offer(node.right);
        }
        return root;
    }


    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree();
        A226_InvertBinaryTree invertBinaryTree = new A226_InvertBinaryTree();
//        TreeNode result = invertBinaryTree.invertTree(root);
//        TreeNode.printTree(result);

        TreeNode result = invertBinaryTree.invertTree2(root);
        TreeNode.printTree(result);
    }
}
