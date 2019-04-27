import java.util.ArrayList;
import java.util.List;

public class A54_SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0)
            return res;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0, right = cols-1, up = 0, down = rows-1;
        while(true){
            for (int  i = left;  i <= right;  i++) {
                res.add(matrix[up][i]);
            }
            if(++up>down) break;
            for (int i = up; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            if(--right<left) break;
            for (int i = right; i >= left ; i--) {
                res.add(matrix[down][i]);
            }
            if(--down<up) break;
            for (int i = down; i >= up; i--) {
                res.add(matrix[i][left]);
            }
            if(++left>right) break;
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5}};
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
//        A54_SpiralMatrix spiralMatrix = new A54_SpiralMatrix();
//        List<Integer> res = spiralMatrix.spiralOrder(matrix);
//        for(int i : res) {
//            System.out.print(i + " ");
//        }
    }

}
