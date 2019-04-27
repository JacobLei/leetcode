import java.util.LinkedList;
import java.util.Queue;

public class A542_01Matrix {

    /**
     * 思路：如果是0，则加入队列，如果是1，改为最大值。
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix){
        if(matrix == null || matrix.length == 0){
            return matrix;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i=0; i<rows; ++i){
            for(int j=0; j<cols; ++j){
                if(matrix[i][j] == 0)
                    q.offer(new int[]{i, j});           // 把元素加入队列中，以备波及影响周围元素
                else
                    matrix[i][j] = Integer.MAX_VALUE;   // 将元素不为0的值设为最大值，方便求0元素影响值
            }
        }

        // 方向数组        上      下      左       右
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!q.isEmpty()){
            int cell[] = q.poll();
            for(int[] d : dirs){
                int row = cell[0] + d[0];       // 横坐标
                int col = cell[1] + d[1];       // 纵坐标
                if(row<0 || col<0 || row >=rows || col >=cols)
                    continue;
                int value = matrix[row][col];   // 获取上下左右的值
                int center = matrix[cell[0]][cell[1]];  // 获取中心的值
                if(value <= center + 1)         // center+1减少重复的比较
                    continue;
                q.offer(new int[]{row, col});
                matrix[row][col] = center + 1;
            }
        }
        return matrix;
    }


    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        A542_01Matrix myMatrix = new A542_01Matrix();

        int[][] res = myMatrix.updateMatrix(matrix);

        for(int[] m : res){
            for(int i : m){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
