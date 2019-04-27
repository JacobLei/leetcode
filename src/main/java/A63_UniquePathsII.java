public class A63_UniquePathsII {

    /**
     * 思路：
     *      开始想着需要申请的辅助空间，后来仔细想想可以可以在原数组上修改路径的大小。
     *      这一题与上一题不同的是增加了障碍物，因此不能将所有的网格初始化为1.
     *      由于到达第(i,j)的网络的路径数量与第(i-1,j)网格和第(i,j-1)网格的数量有关，
     *      因此需要可以得到状态方程为 a[i][j] = a[i-1][j] + a[i][j-1]。
     *      由条件可知，如果网格上由障碍物，则到达该网格的路径数为0，
     *      如果没有障碍物，第0行和第0列的路径为1.
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0)
            return 0;
        
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == 1)
                    obstacleGrid[i][j] = 0;
                else if (i == 0 && j == 0)
                    obstacleGrid[i][j] = 1;
                else if (i== 0 && j > 0)
                    obstacleGrid[i][j] = obstacleGrid[i][j-1];
                else if (j == 0 && i > 0)
                    obstacleGrid[i][j] = obstacleGrid[i-1][j];
                else
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
            }
        }

        return obstacleGrid[n-1][m-1];
    }

    public static void main(String[] args) {
        int[][] obj = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        A63_UniquePathsII uniquePathsII = new A63_UniquePathsII();
        int res = uniquePathsII.uniquePathsWithObstacles(obj);
        System.out.println(res);
    }
}
