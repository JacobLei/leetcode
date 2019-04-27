import java.util.LinkedList;
import java.util.List;

public class A95_UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n){
        return genTrees(1, n);
    }

    private List<TreeNode> genTrees(int start, int end) {
        List<TreeNode> list = new LinkedList<>();

        if(start > end){
            list.add(null);
            return list;
        }

        if(start == end){
            list.add(new TreeNode(start));
            return list;
        }

        List<TreeNode> left, right;
        for (int i = start; i <= end; i++) {
            left = genTrees(start, i-1);
            right = genTrees(i+1, end);

            for(TreeNode lnode : left){
                for(TreeNode rnode : right){
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        A95_UniqueBinarySearchTreesII searchTrees = new A95_UniqueBinarySearchTreesII();
        List<TreeNode> list = searchTrees.generateTrees(5);

        for (TreeNode node : list){
            TreeNode.printTree(node);
            System.out.println();
        }
    }
}
