import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A508_MostFrequentSubtreeSum {
    Map<Integer, Integer> sumToCount;
    int maxCount;

    public int[] findFrequentTreeSu(TreeNode root){
        maxCount = 0;
        sumToCount = new HashMap<Integer, Integer>(); // <子树和， 出现次数>
        postOrder(root);
        List<Integer> list = new ArrayList<>();
        for(int key : sumToCount.keySet()){
            if(sumToCount.get(key) == maxCount){
                list.add(key);
            }
        }

        int len = list.size();
        int[] res = new int[len];
        for(int i=0; i<len; i++){
            res[i] = list.get(i);
        }

        return res;
    }

    private int postOrder(TreeNode root) {
        if(root == null)
            return 0;
        int left = postOrder(root.left);    // 求左子树的和
        int right = postOrder(root.right);  // 求右子树的和

        int sum = left + right + root.val;
        int count = sumToCount.getOrDefault(sum, 0) + 1;
        sumToCount.put(sum, count);
        maxCount = Math.max(maxCount, count);

        return sum;
    }
}
