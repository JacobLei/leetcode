import java.util.*;

public class A103_BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(root==null)
            return ret;
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(root);

        while(!stack1.isEmpty() || !stack2.isEmpty()){
            List<Integer> tmp = new ArrayList<Integer>();
            if(!stack1.isEmpty()){
                while(!stack1.isEmpty()){
                    root = stack1.pop();
                    tmp.add(root.val);
                    if(root.left!=null)
                        stack2.push(root.left);
                    if(root.right!=null)
                        stack2.push(root.right);
                }
                ret.add(tmp);
            }else{
                while (!stack2.isEmpty()){
                    root = stack2.pop();
                    tmp.add(root.val);
                    if(root.right!=null)
                        stack1.push(root.right);
                    if(root.left!=null)
                        stack1.push(root.left);
                }
                ret.add(tmp);
            }

        }
        return ret;
    }
}
