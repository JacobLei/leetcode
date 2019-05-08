public class A200_NumberofIslands {

    /**
     * 本题为求岛屿的个数，可以使用深度优先遍历算法。
     * 首先需要遍历二位数组，当遇到标记为'1'的网格时，分别查找该网格的上下左右；
     *      查找方式为：查找时先做边界判断：当越界时直接返回；
     *                  然后判断该网格(grid[row][col])是否等于'1'，
     *                      若不等于则直接返回；
     *                      如等于，直接在原数组下修改网格(grid[row][col])为'0'，表示已经遍历过；
     *                      然后分别递归遍历上下左右。
     *
     *
     *
     * 遍历数组，如果遇到了'1'，count++,并用DFS将其联通区域的'1'置位'0'
     * @param grid 输入的矩阵
     * @return 岛屿的个数
     */
    public int numIslands(char[][] grid){
        int ret = 0;
        int rows = grid.length;
        if(rows == 0)
            return ret;
        int cols = grid[0].length;

        for(int i=0; i<rows; ++i){
            for(int j=0; j<cols; ++j){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    ret++;
                }
            }
        }

        return ret;
    }

    private void dfs(char[][] grid, int i, int j) {
        if(i<0 || i>grid.length-1 || j<0 || j>grid[0].length-1 || grid[i][j] != '1')
            return ;
        grid[i][j] = '0';
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }

    public static void main(String[] args) {
        char[][] grid1 = { {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};

        char[][] grid2 = { {'1', '1', '0', '0', '0'},
                            {'1', '1', '0', '0', '0'},
                            {'0', '0', '1', '0', '0'},
                            {'0', '0', '0', '1', '1'}};

        A200_NumberofIslands numberofIslands = new A200_NumberofIslands();
        System.out.println(numberofIslands.numIslands(grid1));
        System.out.println(numberofIslands.numIslands(grid2));
    }
}
