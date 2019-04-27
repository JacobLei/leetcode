import java.util.ArrayList;

public class A143_ReorderList {

    public void reorderList(ListNode head){
        if(head == null || head.next == null)
            return ;

        // 1. 将链表分为两部分
        ListNode pre = null, slow = head, fast = head, l1 = head;

        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        pre.next = null;

        // 2. 将后部分反转
        ListNode l2 = reverse(slow);

        // 3. 合并两个链表
        merge(l1, l2);
    }

    // 合并链表
    private void merge(ListNode l1, ListNode l2) {
        while(l1 != null){
            ListNode next1 = l1.next, next2 = l2.next;
            l1.next = l2;

            if(next1 == null)
                break;

            l2.next = next1;
            l1 = next1;
            l2 = next2;
        }
    }

    // 反转链表
    private ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;

        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
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

        A143_ReorderList reorderList = new A143_ReorderList();
        reorderList.reorderList(a);
    }
}
