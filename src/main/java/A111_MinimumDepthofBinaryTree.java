import java.util.LinkedList;
import java.util.Queue;

public class A111_MinimumDepthofBinaryTree {
    /**
     *  非递归实现
     *  思路：层次遍历二叉树，遇见根结点就返回最小深度
     */
    public int minDepth(TreeNode root){
        int depth = 0;
        if(root==null)
            return depth;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            ++depth;
            for(int i=0; i<len; ++i){
                TreeNode node = queue.poll();
                if(node.left==null && node.right==null)
                    return depth;
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
        }
        return depth;
    }

    /**
     *  递归实现
     *  思路：和求最大的深度思路一样，但在左子树或右子树为空的时候有区别。
     */

    public int minDepth2(TreeNode root){
        if(root == null)
            return 0;
        if(root.left == null)
            return minDepth2(root.right) + 1;
        if(root.right == null)
            return minDepth2(root.left) + 1;
        return Math.min(minDepth2(root.left), minDepth2(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree();
        A111_MinimumDepthofBinaryTree minDepth = new A111_MinimumDepthofBinaryTree();

        System.out.println(minDepth.minDepth(root));
        System.out.println(minDepth.minDepth2(root));

    }
}
