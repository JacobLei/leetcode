public class A148_SortList {

    // 思路：
    //      1. 将链表从中间分成两部分
    //      2. 递归对这两部分链表进行排序
    //      3. 合并这两部分链表
    public ListNode sortList(ListNode head){
        if(head == null || head.next == null)
            return head;

        int count = 0, middle = 0;
        ListNode p = head, left = head, right = null;

        // 求出链表长度
        while(p != null){
            count++;
            p = p.next;
        }

        // 将链表划分为两个链表
        middle = count / 2;
        p = head;
        for (int i = 0; i < middle - 1; i++) {
            p = p.next;
        }
        right = p.next;
        p.next = null;

        // 递归调用
        left = sortList(left);
        right = sortList(right);

        // 合并两个链表
        ListNode res = mergeTwoList(left, right);

        return res;
    }

    private ListNode mergeTwoList(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1), pre = dummy;

        while(left != null && right != null){
            if(left.val<=right.val){  // 左链表较小
                pre.next = left;
                left = left.next;
            }else {     // 右链表较小
                pre.next = right;
                right = right.next;
            }
            pre = pre.next;
        }
        if(left != null){
            pre.next = left;
        }
        if(right != null){
            pre.next = right;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(3);

        a.next = b;
        b.next = c;
        c.next = d;

        A148_SortList sortList = new A148_SortList();
        ListNode res = sortList.sortList(a);
        ListNode.printList(res);
    }
}
