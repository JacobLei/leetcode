class MyLinkedList {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
            next = null;
        }
    }

    private ListNode head = null;
    private int total = 0;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new ListNode(-1);
        total = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(total<=index){
            return -1;
        }

        int res = 0;
        ListNode node = head.next;
        for(int i=0; i<index; i++){
            node = node.next;
        }
        return node.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        total++;
        ListNode next = head.next;
        ListNode node = new ListNode(val);
        head.next = node;
        node.next = next;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        total++;
        ListNode pre = head;
        ListNode newNode = new ListNode(val);
        while(pre.next != null){
            pre = pre.next;
        }

        pre.next = newNode;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index == total){
            addAtTail(val);
        }else if(index < total){
            total++;
            ListNode node = new ListNode(val);
            ListNode pre = head;
            for(int i=0; i<index; i++){
                pre = pre.next;
            }
            ListNode next = pre.next;
            pre.next = node;
            node.next = next;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        ListNode pre = head;
        if(total > index){
            for(int i=0; i<index; i++){
                pre = pre.next;
            }
            pre.next = pre.next.next;
            total--;
        }
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
        System.out.println(linkedList.get(1));   // returns 2
        linkedList.deleteAtIndex(1);  // now the linked list is 1->3
        System.out.println(linkedList.get(1));           // returns 3
    }
}
