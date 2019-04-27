import java.util.HashSet;
import java.util.Set;

public class A653_TwoSumIVInputisaBST {
    Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k){
        int max = Integer.MAX_VALUE;
        if(root == null)
            return false;
        return  dfs(root, k);
    }

    private boolean dfs(TreeNode node, int k){
        if(node == null)
            return false;
        if(set.contains(k-node.val))
            return true;
        set.add(node.val);
        return dfs(node.left, k) || dfs(node.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree();
        A653_TwoSumIVInputisaBST twoSum = new A653_TwoSumIVInputisaBST();

        System.out.println(twoSum.findTarget(root, 5));

    }
}
