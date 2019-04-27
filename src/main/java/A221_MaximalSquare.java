public class A221_MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0)
            return 0;
        int rows = matrix.length, cols = matrix[0].length;
        int max = 0;
        int[][] dp = new int[rows][cols];

        // 第一列赋值
        for (int i = 0; i < rows; i++) {
            dp[i][0] = matrix[i][0] - '0';
            max = Math.max(max,dp[i][0]);
        }

        // 第一行赋值
        for (int i = 0; i < cols; i++) {
            dp[0][i] = matrix[0][i] - '0';
            max = Math.max(max, dp[0][i]);
        }

        // 递推：状态转移方程
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = matrix[i][j] == '1'
                        ? Math.min(dp[i-1][j-1],
                        Math.min(dp[i-1][j], dp[i][j-1])) + 1 : 0;  // 状态转移方程
                max = Math.max(max, dp[i][j]);
            }
        }

        return max * max;
    }

    public static void main(String[] args) {
        A221_MaximalSquare maximalSquare = new A221_MaximalSquare();
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        int res = maximalSquare.maximalSquare(matrix);
        System.out.println(res);
    }
}
