import java.lang.reflect.Array;
import java.util.*;

public class A743_NetworkDelayTime {

    public int networkDelayTime(int[][] times, int N, int K){
        int r = times.length;            // 有向边的总条数
        int max = Integer.MAX_VALUE;
        int res = -1;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<r; ++i){
            int[] nums = times[i];      // 第i条边
            int u = nums[0];            // 第i条边的起点位置
            int v = nums[1];            // 第i条边的终点位置
            List<Integer> list = map.getOrDefault(u, new ArrayList<>());

            list.add(i);
            map.put(u, list);
        }
        if(map.get(K) == null){
            return res;              // 邻接矩阵中没有邻接点
        }

        int[] dist = new int[N+1];  // dist[i] 是从结点K到结点i所用的时间
        Arrays.fill(dist, max);

        dist[K] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(K);
        // BFS
        while( !queue.isEmpty() ){
            int u = queue.poll();
            int t = dist[u];
            List<Integer> list = map.get(u);    // 获得u所有的邻接结点
            if(list == null)
                continue;

            for(int n : list){
                int v = times[n][1];
                int time = times[n][2];     // 从结点u到v所用的时间
                if(dist[v] > t + time){
                    dist[v] = t + time;
                    queue.add(v);           // 寻找v的下一个结点
                }
            }
        }

        for(int i=1; i<=N; ++i){
            int d = dist[i];
            if(d == max)
                return -1;
            res = d > res ? d : res;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] times = {{2, 1, 1,}, {2, 3, 1}, {3, 4, 1}};
        int N = 4;
        int K = 2;
        A743_NetworkDelayTime networkDelayTime = new A743_NetworkDelayTime();
        System.out.println(networkDelayTime.networkDelayTime(times, N, K));
    }

}
