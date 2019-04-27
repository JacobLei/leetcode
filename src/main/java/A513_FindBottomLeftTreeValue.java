public class A513_FindBottomLeftTreeValue {
   int ans = 0;
   int h = 0;

    public int findBottomLeftValue(TreeNode root){
        findBottomLeftValue(root, 1);

        return ans;
    }

    private void findBottomLeftValue(TreeNode node, int depth){
        if(depth>h){
            h = depth;
            ans = node.val;
        }

        if(node.left != null)
            findBottomLeftValue(node.left, depth+1);
        if(node.right != null)
            findBottomLeftValue(node.right, depth+1);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree();
        A513_FindBottomLeftTreeValue findBottom = new A513_FindBottomLeftTreeValue();
//        TreeNode.printTree(root);
        System.out.println(findBottom.findBottomLeftValue(root));
    }
}
