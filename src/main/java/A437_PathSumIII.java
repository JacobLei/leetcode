public class A437_PathSumIII {
    /**
     *  运用双递归来解决，
     *  一个递归实现dfs
     *  一个递归实现从每个节点开始去查找
     */
    public int pathSum(TreeNode root, int sum){
        if(root == null)
            return 0;
        return DFS(root, sum)
                + pathSum(root.left, sum)
                + pathSum(root.right, sum);
    }

    private int DFS(TreeNode node, int sum) {
        int res = 0;
        if(node == null)
            return res;
        if(node.val == sum)
            res++;
        res +=  DFS(node.left, sum - node.val);
        res +=  DFS(node.right, sum - node.val);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree();

        A437_PathSumIII pathSumIII = new A437_PathSumIII();
        System.out.println(pathSumIII.pathSum(root, 3));
    }
}
