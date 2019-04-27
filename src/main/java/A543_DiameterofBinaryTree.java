import java.util.HashMap;
import java.util.Map;

public class A543_DiameterofBinaryTree {

    /**
     *  采用双递归的方式
     *  并用哈希表建立每个节点与其深度之间的映射，这样某个节点的深度之前计算过，就不需要再次计算。
     */
    private Map<TreeNode, Integer> hashMap = new HashMap<>();
    public int diameterOfBinaryTree(TreeNode root){
        int ret = 0;
        if(root == null)
            return ret;
        ret = getLen(root.left) + getLen(root.right);
        return Math.max(ret,
                Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    }

    private int getLen(TreeNode node) {
        if(node == null)
            return 0;
        if(hashMap.containsKey(node))
            return hashMap.get(node);
        hashMap.put(node, Math.max(getLen(node.left), getLen(node.right)) + 1);
        return hashMap.get(node);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree();
        A543_DiameterofBinaryTree diameterofBinaryTree = new A543_DiameterofBinaryTree();
        System.out.println(diameterofBinaryTree.diameterOfBinaryTree(root));
    }
}
