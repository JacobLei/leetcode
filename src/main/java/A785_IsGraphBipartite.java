import java.util.Arrays;

public class A785_IsGraphBipartite {

    /**
     *  染色法
     * @param graph
     * @return
     */
    public boolean isBipartitle(int[][] graph){
       int[] colors = new int[graph.length];    // 存储图上每个结点的染色信息
        Arrays.fill(colors, -1);            // 定义-1为未染色，染色时分别用0和-1表示

        for(int i=0; i<graph.length; ++i){
            if(colors[i] == -1 && !dfs(graph, colors, 0, i))
                return false;
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] colors, int color, int node) {
        if(colors[node] != -1)              // 判断该点是否已经染色
            return colors[node] == color;   // 若已经染色，则判断是否符合预期

        colors[node] = color;               // 对点染色
        for (int next : graph[node]){       // 进行DFS，遍历当前点的邻接点，
            if(!dfs(graph, colors, 1-color, next))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        A785_IsGraphBipartite isGraphBipartite = new A785_IsGraphBipartite();

        System.out.println(isGraphBipartite.isBipartitle(graph));
    }

}
