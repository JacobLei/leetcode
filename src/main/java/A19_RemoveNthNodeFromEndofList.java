public class A19_RemoveNthNodeFromEndofList {

    public ListNode removeNthFromEnd1(ListNode head, int n) {

        if(head == null){
            return head;
        }

        ListNode p = head;
        int len = 1;

        // 统计链表节点的个数
        while(p.next != null){
            p = p.next;
            len++;
        }

        // 计算删除节点的位置
        int pos = len - n + 1;

        // 删除节点如果为第一个节点，则直接返回head.next
        if(pos == 1)
            return head.next;

        // 重置p指针的位置
        p = head;

        // 查找需要删除节点的前一个节点
        for(int i=1; i<pos-1; i++){
            p = p.next;
        }

        // 删除该节点
        p.next = p.next.next;

        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        // 声明快慢指针
        ListNode fast = head, slow = head;

        // fast指针走n步
        while(n > 0){
            fast = fast.next;
            n--;
        }

        // 判断需要删除的节点是否为第一个节点
        if(fast == null){
            return head.next;
        }

        // 同时移动快慢指针
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        // 删除节点
        slow.next = slow.next.next;

        return head;
    }
}
