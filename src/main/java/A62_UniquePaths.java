public class A62_UniquePaths {

    /**
思路：典型的动态规划。
     首先申请m*n大小的辅助空间，并将其初始化为1；
     然后更新辅助空间的中的值，
         规律为：a[i][j] = a[i-1][j] + a[i][j-1](1<=i<m, 1<=j<n)
     最后返回a[m-1][n-1]
     * @param m
     * @param n
     * @return
     */
    public int getPath(int m, int n){
        // 申请辅助空间
        int[][] help = new int[m][n];

        // 初始化辅助空间
        for (int i=0; i<m; i++){
            for (int j = 0; j < n; j++) {
                help[i][j] = 1;
            }
        }

        // 改变辅助空间中的对应值
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                help[i][j] = help[i-1][j] + help[i][j-1];
            }
        }

        return help[m-1][n-1];
    }

    public static void main(String[] args) {
        A62_UniquePaths uniquePaths = new A62_UniquePaths();
        int res = uniquePaths.getPath(3, 3);
        System.out.println(res);
    }
}
