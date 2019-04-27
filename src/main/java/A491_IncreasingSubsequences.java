import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class A491_IncreasingSubsequences {

    public List<List<Integer>> findsubsequences(int[] nums){
       List<List<Integer>> ret = new LinkedList<>();

       dfs(new LinkedList<Integer>(), 0, nums, ret);
       return ret;
    }

    // dfs+回溯法可以理解为dfs+bfs
    private void dfs(LinkedList<Integer> list, int index, int[] nums, List<List<Integer>> ret) {
        if(list.size()>1)
            ret.add(new LinkedList<Integer>(list));
        Set<Integer> used = new HashSet<>();             // 记录每一层遍历时的不重复元素
        for (int i = index; i < nums.length; i++) {     // 同层次向后遍历
            if(used.contains(nums[i]))                    // 当该数遍历过，则抛弃
                continue;
            if(list.size()==0 || nums[i]>=list.peekLast()){
                list.add(nums[i]);
                used.add(nums[i]);
                dfs(list, i+1, nums, ret);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 7};
        A491_IncreasingSubsequences increasingSubsequences = new A491_IncreasingSubsequences();
        List<List<Integer>> ret = increasingSubsequences.findsubsequences(nums);

        for(List<Integer> list : ret){
            for (int l : list){
                System.out.print(l + " ");
            }
            System.out.println();
        }
    }
}
