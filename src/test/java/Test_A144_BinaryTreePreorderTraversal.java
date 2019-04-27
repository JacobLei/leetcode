import java.util.List;

public class Test_A144_BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        A144_BinaryTreePreorderTraversal traversal =
                new A144_BinaryTreePreorderTraversal();
        TreeNode root = TreeNode.createTree();
        List<Integer> ret =  traversal.preorderTraversal(root);

        for(Integer i : ret)
            System.out.print(i + " ");
    }
}
