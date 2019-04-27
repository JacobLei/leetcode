public class A79_WordSearch {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0)
            return false;
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(dfs(board, word, 0, i, j, visited))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int idx, int i, int j, boolean[][] visited){
        if(word.length() == idx) return true;
        int rows = board.length;
        int cols = board[0].length;
        if(i<0 || j<0 || i>=rows || j>=cols || visited[i][j] == true || word.toCharArray()[idx] != board[i][j]){
            return false;
        }

        visited[i][j] = true;
        boolean res = dfs(board, word, idx+1, i-1, j, visited)
                || dfs(board, word, idx+1, i+1, j, visited)
                || dfs(board, word, idx+1, i, j-1, visited)
                || dfs(board, word, idx+1, i, j+1, visited);
        visited[i][j] = false;
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {  {'A'}};
        String word = "A";

        A79_WordSearch wordSearch = new A79_WordSearch();
        System.out.println(wordSearch.exist(board, word));
    }
}
