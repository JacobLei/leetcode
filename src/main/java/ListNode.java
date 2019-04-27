public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        this.val = x;
        next = null;
    }

    public static ListNode createListNode(){
        ListNode a = new ListNode(-10);
        ListNode b = new ListNode(-3);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(9);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        return a;
    }

    public static void printList(ListNode root){
        while(root != null){
            System.out.print(root.val + " ");
            root = root.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode root = ListNode.createListNode();
        ListNode.printList(root);
    }

}
