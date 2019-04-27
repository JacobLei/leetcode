import java.util.ArrayList;
import java.util.List;

public class A257_BinaryTreePaths {
    public List<String> ret = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root){
        if(root == null)
            return ret;
        findPaths(root, root.val + "");
        return ret;
    }

    private void findPaths(TreeNode node, String path) {
        if(node.left == null && node.right == null)
            ret.add(path);
        if(node.left != null)
            findPaths(node.left, path + "->" + node.left.val);
        if(node.right != null)
            findPaths(node.right, path + "->" + node.right.val);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree();
        A257_BinaryTreePaths binaryTreePaths = new A257_BinaryTreePaths();
        List<String> result = binaryTreePaths.binaryTreePaths(root);
        for(String s : result)
            System.out.println(s);
    }
}
