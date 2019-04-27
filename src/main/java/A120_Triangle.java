import java.util.Arrays;
import java.util.List;

public class A120_Triangle {
    // 重底向上查找
    public int minimumTotal(List<List<Integer>> triangle){
        if(triangle.size() == 1)
            return triangle.get(0).get(0);

        int[] dp = new int[triangle.size()];

        // 将最底部的数字赋值给dp数组
        for (int i=0; i<triangle.get(triangle.size()-1).size(); i++){
            dp[i] = triangle.get(triangle.size()-1).get(i);
        }

        for (int i=triangle.size()-2; i>=0; i--){
            for (int j=0; j<triangle.get(i).size(); j++){
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        A120_Triangle triangle = new A120_Triangle();
    }
}
