public class A725_SplitLinkedListinParts {
    public ListNode[] splitListToParts(ListNode root, int k){
        ListNode[] res = new ListNode[k];
        int len = 0;
        ListNode node = root, pre = null;
        while(node != null){
            len++;
            node = node.next;
        }

        int n = len / k, r = len % k;
        node = root;
        for (int i = 0; node != null && i < k ; i++, r--) {
            res[i] = node;
            for (int j = 0; j < n + (r > 0 ? 1 : 0); j++) {
                pre = node;
                node = node.next;
            }
            pre.next = null;
        }
        return res;
    }

    public static void main(String[] args) {
        int i = -123;
        System.out.println(i % 10);
    }
}
