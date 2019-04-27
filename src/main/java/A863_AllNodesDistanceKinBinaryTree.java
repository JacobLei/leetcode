import org.omg.PortableInterceptor.INACTIVE;
import sun.reflect.generics.tree.Tree;

import java.util.*;

public class A863_AllNodesDistanceKinBinaryTree {
    // 1. build a undirected grpah using treenodes as vertices, and the parent-child relation as edges.
    // 2. do BFS with source vertice(target) to find all vertices with distance K to it.

    Map<TreeNode, List<TreeNode>> hashMap = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K){
        List<Integer> ret = new ArrayList<Integer>();
        if(root == null || K < 0)
            return ret;
        buildMap(root, null);
        if(!hashMap.containsKey(target))
            return ret;
        Set<TreeNode> visited = new HashSet<TreeNode>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        visited.add(target);
        q.add(target);

        // BFS
        while (!q.isEmpty()){
            int size = q.size();
            if(K == 0){
                for(int i=0; i<size; ++i){
                    ret.add(q.poll().val);
                }
                return ret;
            }

            for(int i=0; i<size; ++i){
                TreeNode node =  q.poll();
                for(TreeNode next : hashMap.get(node)){
                    if(visited.contains(next)) continue;
                    visited.add(next);
                    q.add(next);
                }
            }
            K--;
        }

        return ret;
    }

    private void buildMap(TreeNode node, TreeNode parent) {
        if(node == null)
            return ;
        if(!hashMap.containsKey(node)){
            hashMap.put(node, new ArrayList<>());
            if(parent != null){
                hashMap.get(node).add(parent);
                hashMap.get(parent).add(node);
            }
            buildMap(node.left, node);
            buildMap(node.right, node);
        }
    }

    public static void main(String[] args) {
        A863_AllNodesDistanceKinBinaryTree allNodes = new A863_AllNodesDistanceKinBinaryTree();
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        List<Integer> ret = allNodes.distanceK(a, b, 1);

//        System.out.println(ret.size());
        for(int i : ret)
            System.out.print(i);
    }
}
