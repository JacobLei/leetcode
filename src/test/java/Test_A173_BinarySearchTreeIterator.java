public class Test_A173_BinarySearchTreeIterator {

    public static void main(String[] args) {
        TreeNode root = TreeNode.creatBST();
        A173_BinarySearchTreeIterator iterator = new A173_BinarySearchTreeIterator(root);

        while(iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
    }

}
