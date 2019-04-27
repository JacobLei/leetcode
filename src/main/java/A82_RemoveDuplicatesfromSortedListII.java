public class A82_RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode(-1), pre = res;
        res.next = head;

        while(pre.next != null){
            ListNode cur = pre.next;
            while(cur.next != null && cur.next.val == cur.val){
                cur = cur.next;
            }
            if(cur != pre.next)
                pre.next = cur.next;
            else
                pre = pre.next;
        }

        return res.next;
    }
}
