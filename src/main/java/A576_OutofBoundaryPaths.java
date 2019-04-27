public class A576_OutofBoundaryPaths {

    /**
     *
     * @param m 横坐标位置
     * @param n 纵坐标位置
     * @param N 移动次数
     * @param i 起始横坐标位置
     * @param j 起始纵坐标位置
     * @return
     */
    public int findPaths(int m, int n, int N, int i, int j){
        final int NUMMOD = 1000000007;
        int[][][] dp = new int[N+1][m][n];
        int[] dirs = {-1, 0, 1, 0, -1};
        for (int k = 1; k <= N; k++) {
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    for(int d=0; d<4; ++d){
                        int tx = x + dirs[d];
                        int ty = y + dirs[d+1];
                        if(tx<0 || tx>=m || ty<0 || ty>=n)
                            dp[k][x][y] += 1;
                        else
                            dp[k][x][y] = (dp[k][x][y] + dp[k-1][tx][ty]) % NUMMOD;
                    }
                }
            }

        }
        return dp[N][i][j];
    }

    public static void main(String[] args) {
        A576_OutofBoundaryPaths outof = new A576_OutofBoundaryPaths();
        System.out.println(outof.findPaths(1, 3, 3, 0, 1));
    }
}
