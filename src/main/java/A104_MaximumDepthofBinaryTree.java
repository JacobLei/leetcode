import java.util.LinkedList;
import java.util.Queue;

public class A104_MaximumDepthofBinaryTree {
    /**
     *  二叉树的最大深度问题用深度优先搜索DFS，
     *  递归的完美应用，与求二叉树最小深度问题的原理相同
     */
    public static int maxDepth(TreeNode root){
        if(root==null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // 二叉树的层次遍历也可以求出
    public static int maxDepth2(TreeNode root){
        if(root == null)
            return 0;
        int ret = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            ++ret;
            int len = queue.size();
            for(int i=0; i<len; ++i){
                TreeNode node = queue.poll();
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree();
//        TreeNode.printTree(root);

        System.out.println(A104_MaximumDepthofBinaryTree.maxDepth2(root));
    }
}
