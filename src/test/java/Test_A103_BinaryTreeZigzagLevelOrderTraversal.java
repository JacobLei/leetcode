import java.util.List;

public class Test_A103_BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree();
        A103_BinaryTreeZigzagLevelOrderTraversal traversal =
                new A103_BinaryTreeZigzagLevelOrderTraversal();

        List<List<Integer>> ret = traversal.zigzagLevelOrder(root);
        for(List<Integer> li : ret){
            for(Integer i : li)
                System.out.print(i + " ");
            System.out.println();
        }

    }

}
