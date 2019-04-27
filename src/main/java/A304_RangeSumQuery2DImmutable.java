import sun.nio.cs.ext.MacHebrew;

import java.util.concurrent.locks.ReentrantLock;

class NumMatrix {

    ReentrantLock reentrantLock = new ReentrantLock();

    private int[][] dp;

    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;

        int rows = matrix.length, cols = matrix.length;
        dp = new int[rows+1][cols+1];

        for (int i = 1; i <rows+1 ; i++) {
            for (int j = 1; j < cols+1; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int rowMin = Math.min(row1, row2);
        int rowMax = Math.max(row1, row2);
        int colMin = Math.min(col1, col2);
        int colMax = Math.max(col1, col2);

        return dp[rowMax+1][colMax+1]
                - dp[rowMax+1][colMin]
                - dp[rowMax][colMin+1]
                + dp[rowMax][colMin];
    }

}
