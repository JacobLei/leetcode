import java.util.ArrayList;
import java.util.List;

public class A442_FindAllDuplicatesinanArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int pos = Math.abs(nums[i]) - 1;
            if(nums[pos] < 0)
                res.add(pos+1);
            nums[pos] = -nums[pos];         // 将出现过的位置取反
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        A442_FindAllDuplicatesinanArray findAllDuplicatesinanArray =
                new A442_FindAllDuplicatesinanArray();

        List<Integer>  res = findAllDuplicatesinanArray.findDuplicates(nums);
        for(int r : res){
            System.out.println(r);
        }
    }
}
