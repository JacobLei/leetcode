public class A109_ConvertSortedListtoBinarySearchTree {
    public TreeNode soredListToBST(ListNode head){
        if(head == null)
            return null;
        return buildBST(head, null);
    }

    private TreeNode buildBST(ListNode head, ListNode tail) {
        if(head == tail)
            return null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast!= tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode node = new TreeNode(slow.val);
        node.left = buildBST(head, slow);
        node.right = buildBST(slow.next, tail);
        return node;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createListNode();
        A109_ConvertSortedListtoBinarySearchTree convert = new A109_ConvertSortedListtoBinarySearchTree();
        TreeNode root = convert.soredListToBST(head);
        TreeNode.printTree(root);
    }
}
