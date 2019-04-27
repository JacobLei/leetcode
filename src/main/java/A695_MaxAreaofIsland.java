import java.util.HashMap;
import java.util.Map;

public class A695_MaxAreaofIsland {


    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        if(grid == null || grid[0].length == 0)
            return res;
        int rows = grid.length, cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j] == 1){
                    int area = dfs(grid, i, j, 0);
                    res = Math.max(res, area);
                }
            }
        }

        return res;
    }

    private int dfs(int[][] grid, int i, int j, int cnt) {
        int rows = grid.length, cols = grid[0].length;
        if(i<0 || j < 0 || i>=rows || j>= cols || grid[i][j] <= 0)
            return cnt;
        grid[i][j] *= -1;
        cnt++;
        cnt = dfs(grid, i, j+1, cnt);
        cnt = dfs(grid, i, j-1, cnt);
        cnt = dfs(grid, i+1, j, cnt);
        cnt = dfs(grid, i-1, j, cnt);
        return cnt;
    }

    public static void main(String[] args) {
//        A695_MaxAreaofIsland maxAreaofIsland = new A695_MaxAreaofIsland();
//        int[][] grid = {{1, 1},
//                        {1, 0}};
//        int res = maxAreaofIsland.maxAreaOfIsland(grid);
//        System.out.println(res);
        int[] nums = {1, 2, 2, 3, 1};
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        for(int num : nums){
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        for(Integer entry : hashMap.keySet()){
            System.out.println(entry + "===> " + hashMap.get(entry));
        }
    }
}
