public class A74_Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
            return false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int i=0;

        while(cols > 0 && i<rows){
            if(matrix[i][cols-1] == target)
                return true;
            else if(matrix[i][cols-1] < target)
                ++i;
            else{
                int left = 0, right = cols-1;
                while(left<=right){
                    int mid = left + (right-left) / 2;
                    if(matrix[i][mid] == target)
                        return true;
                    else if(matrix[i][mid]>target){
                        right = mid - 1;
                    }
                    else{
                        left = mid + 1;
                    }
                }
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5}};
        A74_Searcha2DMatrix searcha2DMatrix = new A74_Searcha2DMatrix();
        System.out.println(searcha2DMatrix.searchMatrix(matrix, 1));
    }
}
