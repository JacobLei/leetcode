public class A130_SurroundedRegions {

    /**
     * 由于边界的O不需要被替换，因此与边界联通的O都不需要被替换，
     * 查询四个边界，如果遇到O则DFS内部是联通的O区域。
     * @param board .
     */
    public void solve(char[][] board){
        int rows = board.length;
        int cols = board[0].length;
        if(rows<3 || cols<3)
            return ;

        // Any '0' connected to boundary can't be turned to 'X'，so ...
        // Start from first and last column, turn '0' to '*'
        for(int i=0; i<rows; ++i){
            if(board[i][0] == 'O')
                dfs(board, i, 0);
            if(board[i][cols-1] == 'O')
                dfs(board, i, cols-1);
        }

        // Start from first and last row, turn '0' to '*'
        for(int i=0; i<cols; ++i){
            if(board[0][i] == 'O')
                dfs(board, 0, i);
            if(board[cols-1][i] == 'O')
                dfs(board, cols-1, i);
        }

        // post-processing, turn '0' to 'X', '*' back to '0', keep 'X' intack .
        for(int i=0; i<rows; ++i){
            for(int j=0; j<cols; ++j){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }

    }

    private void dfs(char[][] board, int i, int j) {
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1)
            return ;
        board[i][j] = '*';
        if(i>0 && board[i-1][j] == 'O')
            dfs(board, i-1, j);
        if(i<board.length-1 && board[i+1][j] == 'O')
            dfs(board, i+1, j);
        if(j>0 && board[i][j-1] == 'O')
            dfs(board, i, j-1);
        if(j<board[0].length-1 && board[i][j+1] == 'O')
            dfs(board, i, j+1);
    }

    public static void main(String[] args) {
        char board[][] = {{'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        A130_SurroundedRegions surroundedRegions = new A130_SurroundedRegions();
        surroundedRegions.solve(board);
        for(int i=0; i<board.length; ++i){
            for(int j=0; j<board[0].length; ++j){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
