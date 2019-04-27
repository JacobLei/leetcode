public class A21_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1), cur = res;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 != null) ? l1 : l2;

        return res.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(1);
        ListNode e = new ListNode(3);
        ListNode f = new ListNode(4);
        a.next = b;
        b.next = c;
        d.next = e;
        e.next = f;

//        while(a != null){
//            System.out.println(a.val);
//            a = a.next;
//        }

        A21_MergeTwoSortedLists mergeTwoSortedLists = new A21_MergeTwoSortedLists();
        ListNode res = mergeTwoSortedLists.mergeTwoLists(a, d);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
