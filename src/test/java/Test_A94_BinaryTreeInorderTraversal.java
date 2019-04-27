import java.util.List;

public class Test_A94_BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree();
        A94_BinaryTreeInorderTraversal inorderTraversal = new A94_BinaryTreeInorderTraversal();
        List<Integer> ret = inorderTraversal.inorderTraversal(root);

        for(Integer i : ret){
            System.out.print(i + " ");
        }
    }
}
