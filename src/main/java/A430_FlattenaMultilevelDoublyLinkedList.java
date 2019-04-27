public class A430_FlattenaMultilevelDoublyLinkedList {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    public Node flatten(Node head){
        if(head == null)
            return head;

        Node p = head;
        while (p != null){
            /* 如果没有child结点*/
            if(p.child == null){
                p = p.next;
                continue;
            }

            /* 如果又child结点*/
            Node tmp = p.child;
            // 找出孩子结点的尾结点
            while(tmp.next != null)
                tmp = tmp.next;
            // 连接孩子结点的尾结点和p.next
            tmp.next = p.next;
            if(p.next != null)
                p.next.prev = tmp;
            p.child.prev = p;
            p.next = p.child;
            p.child = null;
        }

        return head;
    }

}
