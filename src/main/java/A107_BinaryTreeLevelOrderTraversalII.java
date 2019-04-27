import java.io.InputStream;
import java.util.*;

public class A107_BinaryTreeLevelOrderTraversalII {
    /**
     *  自己思路：先层次遍历二叉树，每一层的结果放入栈中，
     *  最后弹出。
     *
     */

    public static List<List<Integer>> levelOrderBottom(TreeNode root){
        List<List<Integer>>  ret = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null)
            return ret;
        q.offer(root);

        while(!q.isEmpty()){
            List<Integer> tmp = new LinkedList<>();
            int len = q.size();

            for(int i=0; i<len; ++i){
                TreeNode node = q.poll();
                tmp.add(node.val);
                if(node.left != null)
                    q.offer(node.left);
                if(node.right != null)
                    q.offer(node.right);
            }
            ret.add(0, tmp);
        }

        return ret;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree();

        List<List<Integer>> result = A107_BinaryTreeLevelOrderTraversalII.levelOrderBottom(root);
        for(List<Integer> list : result){
            for(Integer i : list){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
