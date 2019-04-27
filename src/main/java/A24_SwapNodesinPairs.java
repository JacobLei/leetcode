public class A24_SwapNodesinPairs {
    ListNode swapPairs(ListNode head){
        ListNode res = new ListNode(-1), pre = res;
        res.next = head;
        while(pre.next != null && pre.next.next != null){
            ListNode node = pre.next.next;
            pre.next.next = node.next;
            node.next = pre.next;
            pre.next = node;
            pre = node.next;
        }

        return res.next;
    }
}
