import java.util.HashMap;
import java.util.Map;

public class A105_ConstructBinaryTreefromPreorderandInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder){
        if(preorder == null || inorder == null || preorder.length != inorder.length)
            return null;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0; i<inorder.length; ++i){
            hashMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, hashMap);
    }

    private TreeNode build(int[] preorder, int pb, int pe,
                           int[] inorder, int ib, int ie, Map<Integer, Integer> hashMap) {
        if(pb>pe || ib>ie)
            return null;
        TreeNode node = new TreeNode(preorder[pb]);
        int iPostion = hashMap.get(preorder[pb]);
        node.left = build(preorder, pb+1, pb+iPostion-ib, inorder, ib, iPostion-1, hashMap);
        node.right = build(preorder, pb+iPostion-ib+1, pe, inorder, iPostion+1, ie, hashMap);
        return node;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        A105_ConstructBinaryTreefromPreorderandInorderTraversal constructBinary =
                new A105_ConstructBinaryTreefromPreorderandInorderTraversal();
        TreeNode root = constructBinary.buildTree(preorder, inorder);

        TreeNode.printTree(root);
    }
}
