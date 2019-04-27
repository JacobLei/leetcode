public class A92_ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null)
            return null;
        ListNode dummy = new ListNode(-1), pre = dummy;
        dummy.next = head;

        for (int i = 0; i < m-1; i++) {
            pre = pre.next;
        }

        ListNode start = pre.next;
        ListNode then = start.next;
        // m到n的位置交换
        for(int i=0; i<n-m; i++){
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        return dummy.next;
    }
}
