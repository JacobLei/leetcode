import java.util.Stack;

public class A173_BinarySearchTreeIterator {

    private Stack<TreeNode> stack = new Stack<TreeNode>();

    public A173_BinarySearchTreeIterator(TreeNode root){
            TreeNode node = root;
            while(node!=null){
                stack.push(node);
                node = node.left;
            }
    }

    public boolean hasNext(){
        return !stack.isEmpty();
    }

    public int next(){
        TreeNode node = stack.pop();
        int ret = node.val;
        node = node.right;
        while(node!=null){
            stack.push(node);
            node = node.left;
        }
        return ret;
    }
}
