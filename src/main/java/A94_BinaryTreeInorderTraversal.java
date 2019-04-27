import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class A94_BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> ret = new ArrayList<Integer>();
        if(root == null)
            return ret;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        while( root!=null ||!stack.empty()){
            if(root!=null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                ret.add(root.val);
                root = root.right;
            }
        }

        return ret;
    }
}
