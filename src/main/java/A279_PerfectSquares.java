import java.util.Arrays;

public class A279_PerfectSquares {

    // 动态转移方程: dp[i + j*j] = min(dp[i + j*j], dp[i]+1)
    public int numSquares(int n) {
        if(n < 1)
            return 0;

        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // 将平方的位置置为1
        for (int i = 0; i*i <= n; i++) {
            dp[i*i] = 1;
        }

        // 状态转移
        for (int i = 0; i <= n; i++) {
            for (int j = 0; i + j*j <=n ; j++) {
                dp[i+j*j] = Math.min(dp[i]+1, dp[i+j*j]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        A279_PerfectSquares perfectSquares = new A279_PerfectSquares();
        int res = perfectSquares.numSquares(12);
        System.out.println(res);

    }
}
