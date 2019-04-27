import java.util.LinkedList;
import java.util.Queue;

public class A116_PopulatingNextRightPointersinEachNode {

    /**
     * 对于二叉树的层次遍历，最好还是用BFS
     * @param root
     */
    public void connect(TreeLinkNode root){
        if(root == null)
            return ;
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);

        while(true){
            TreeLinkNode cur = q.poll();
            if(cur != null){
                cur.next = q.peek();
                if(cur.left != null)
                    q.offer(cur.left);
                if(cur.right != null)
                    q.offer(cur.right);
            }else{
                if(q.size() == 0 || q.peek() == null)
                    return ;
                q.offer(null);
            }
        }
    }
}
