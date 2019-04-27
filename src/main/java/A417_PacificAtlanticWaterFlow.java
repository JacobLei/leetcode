import java.util.LinkedList;
import java.util.List;

public class A417_PacificAtlanticWaterFlow {

    public List<int[]> pacificAtlantic(int[][] matrix){
        List<int[]> res = new LinkedList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return res;
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] pacific = new boolean[rows][cols];  // 构建两个visited矩阵
        boolean[][] atlantic = new boolean[rows][cols];

        // 遍历第一列和最后一列
        for (int i = 0; i < rows; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, cols-1);
        }

        // 遍历第一行和最后一行
        for (int i = 0; i < cols; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix,atlantic, Integer.MIN_VALUE, rows-1, 0);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(pacific[i][j] && atlantic[i][j])
                    res.add(new int[]{i, j});
            }
        }

        return res;
    }
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private void dfs(int[][] matrix, boolean[][] visited, int height, int i, int j) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(i<0 || i>=rows || j<0 || j>=cols || visited[i][j] || matrix[i][j]<height){
            return ;
        }
        visited[i][j] = true;
        for(int[] dir : dirs){
            dfs(matrix, visited, matrix[i][j], i+dir[0], j+dir[1]);
        }
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        A417_PacificAtlanticWaterFlow pacificAtlanticWaterFlow = new A417_PacificAtlanticWaterFlow();
        List<int[]> ret = pacificAtlanticWaterFlow.pacificAtlantic(input);

        for (int[] l: ret) {
            for (int i: l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
