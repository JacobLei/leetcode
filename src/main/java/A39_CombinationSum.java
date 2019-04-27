import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A39_CombinationSum {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<Integer>());
        return res;
    }

    private void dfs(int[] candidates, int target, int start, List<Integer> out) {
        if(target < 0)
            return ;
        else if( target == 0){
            res.add(new ArrayList<>(out));
            return ;
        }
        for(int i=start; i<candidates.length; ++i){
            out.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, out);
            out.remove(out.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        int target = 7;
        A39_CombinationSum combinationSum = new A39_CombinationSum();
        List<List<Integer>> res = combinationSum.combinationSum(nums, target);

        for(List<Integer> list : res){
            for (int i : list){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
