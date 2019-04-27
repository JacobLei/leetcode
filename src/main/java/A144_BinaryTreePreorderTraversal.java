import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class A144_BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> ret = new ArrayList<Integer>();
        if(root==null)
            return ret;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while(root!=null || !stack.isEmpty()){
            if(root!=null){
                ret.add(root.val);
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop().right;
            }
        }
        return ret;
    }
}
