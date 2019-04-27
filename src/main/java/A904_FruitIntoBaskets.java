import java.util.HashMap;
import java.util.Map;

public class A904_FruitIntoBaskets {
    // 双指针问题
    public int totalFruit(int[] tree) {
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0, i = 0;
        for (int j = 0; j < tree.length; j++) {
            count.put(tree[j], count.getOrDefault(tree[j], 0) + 1);
            while (count.size()>2){
                count.put(tree[i], count.get(tree[i]) - 1);
                if(count.get(tree[i]) == 0) count.remove(tree[i]);
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] tree = {3,3,3,1,2,1,1,2,3,3,4};
        A904_FruitIntoBaskets fruitIntoBaskets = new A904_FruitIntoBaskets();
        int res = fruitIntoBaskets.totalFruit(tree);
        System.out.println(res);
    }
}
