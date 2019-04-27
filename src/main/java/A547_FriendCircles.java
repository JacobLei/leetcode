public class A547_FriendCircles {

    public int findCircleNum(int[][] M){
        int res = 0;
        if(M == null || M.length == 0)
            return res;
        int[] visited = new int[M.length];
        for(int i=0; i<M.length; ++i){
            if(visited[i] == 0){
                dfs(M, visited, i);
                res++;
            }
        }

        return res;
    }

    private void dfs(int[][] matrix, int[] visited, int i) {
        for(int j=i; j<matrix[i].length; ++j){
            if(matrix[i][j] == 1 && visited[j] ==0){
                visited[j] = 1;
                dfs(matrix, visited, j);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        A547_FriendCircles friendCircles = new A547_FriendCircles();

        System.out.println(friendCircles.findCircleNum(matrix));

    }
}
