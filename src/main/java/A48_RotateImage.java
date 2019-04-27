public class A48_RotateImage {

    public void rotate(int[][] matrix) {

        // 沿主对角线交换matrix[i][j]和matrix[j][i]的值
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 以矩阵中心垂线为中心，matrix[i][j]和matrix[i][matrix[0].length - j]
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length-1-j];
                matrix[i][matrix[0].length-1-j] = temp;
            }
        }
    }
}
