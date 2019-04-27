public class A337_HouseRobberIII {
    public int rob(TreeNode root){

        return dfs(root)[1];
    }

    private int[] dfs(TreeNode root) {
        int[] rob = {0, 0};
        if(root != null){
            int[] robLeft = dfs(root.left);
            int[] robRight = dfs(root.right);
            rob[0] = robLeft[1] + robRight[1];  // 存储从叶节点到当前结点抢劫的最大值
            rob[1] = Math.max(robLeft[0]+robRight[0]+root.val, rob[0]);
        }
        return rob;
    }
}
