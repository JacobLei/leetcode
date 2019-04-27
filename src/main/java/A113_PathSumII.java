import java.util.LinkedList;
import java.util.List;

public class A113_PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum){
        List<List<Integer>> ret = new LinkedList<>();
        List<Integer> curList = new LinkedList<>();
        pathSum(root, sum, curList, ret);
        return ret;
    }

    private void pathSum(TreeNode root, int sum, List<Integer> curList, List<List<Integer>> ret) {
        if(root == null)
            return ;
        curList.add(new Integer(root.val));
        if(sum == root.val && root.left == null && root.right == null){
            ret.add(new LinkedList(curList));
            curList.remove(curList.size()-1);       // 去掉最后一个节点，遍历其他分支
            return ;
        }else {
            pathSum(root.left, sum - root.val, curList, ret);
            pathSum(root.right, sum - root.val, curList, ret);
            curList.remove(curList.size()-1);
        }
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(8);
        TreeNode d = new TreeNode(11);
        TreeNode e = new TreeNode(13);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(2);
        TreeNode i = new TreeNode(5);
        TreeNode j = new TreeNode(1);

        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;
        c.right = f;
        d.left = g;
        d.right = h;
        f.left = i;
        f.right = j;

        A113_PathSumII pathSum = new A113_PathSumII();

        List<List<Integer>> ret = pathSum.pathSum(a, 22);

        for(List<Integer> list : ret){
            for(int l : list){
                System.out.print(l + " ");
            }
            System.out.println();
        }
    }
}
