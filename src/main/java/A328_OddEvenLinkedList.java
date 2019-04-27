public class A328_OddEvenLinkedList {
    //  使用两个指针，pre指向奇结点， cur指向偶结点
    //  然后把偶结点后面的那个奇结点提前到pre后面，
    //  然后pre和cur各自前进一步
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode pre = head, cur = head.next;

        while(cur != null && cur.next != null){
            ListNode tmp = pre.next;
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre.next.next = tmp;
            cur = cur.next;
            pre = pre.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        A328_OddEvenLinkedList oddEvenLinkedList = new A328_OddEvenLinkedList();
        ListNode res = oddEvenLinkedList.oddEvenList(a);

        ListNode.printList(res);
    }
}
