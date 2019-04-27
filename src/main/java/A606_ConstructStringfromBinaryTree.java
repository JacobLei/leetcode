public class A606_ConstructStringfromBinaryTree {
    public String tree2str(TreeNode t){
        if(t == null)
            return "";
        String ret = t.val + "";

        String left = tree2str(t.left);
        String right = tree2str(t.right);

        if(left == "" && right == "") return ret;
        if(left == "") return ret + "()" +"(" + right + ")";
        if(right == "") return ret + "(" + left + ")";
        return ret + "(" + left + ")" + "(" + right + ")";
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree();
        A606_ConstructStringfromBinaryTree constructStringfromBinaryTree = new A606_ConstructStringfromBinaryTree();

        System.out.println(constructStringfromBinaryTree.tree2str(root));
    }
}
