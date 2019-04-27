import java.util.HashMap;
import java.util.Map;

public class A106_ConstructBinaryTreefromInorderandPostorderTraversal {

    public TreeNode buildTreePostIn(int[] inorder, int[] postorder){
        if(inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        Map<Integer, Integer> hashMap = new HashMap<>();    // <inorder[i], i>
        for(int i=0; i<inorder.length; ++i){
            hashMap.put(inorder[i], i);
        }

        return buildTreePostIn(inorder, 0, inorder.length-1,
                postorder, 0, postorder.length-1, hashMap);
    }

    private TreeNode buildTreePostIn(int[] inorder, int ib, int ie, int[] postorder, int pb, int pe, Map<Integer, Integer> hashMap) {
        if(ib > ie || pb > pe)
            return null;
        TreeNode node = new TreeNode(postorder[pe]);
        int inorderPost = hashMap.get(postorder[pe]);
        TreeNode left = buildTreePostIn(inorder, ib, inorderPost-1, postorder, pb, pb+inorderPost-ib-1, hashMap);   // pe+inorderPost-ib后序遍历中的左子树部分
        TreeNode right = buildTreePostIn(inorder, inorderPost+1, ie, postorder, pb+inorderPost-ib, pe-1, hashMap);;
        node.left = left;
        node.right = right;
        return node;
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        A106_ConstructBinaryTreefromInorderandPostorderTraversal constructBinary = new A106_ConstructBinaryTreefromInorderandPostorderTraversal();
        TreeNode root = constructBinary.buildTreePostIn(inorder, postorder);

        TreeNode.printTree(root);
    }
}
