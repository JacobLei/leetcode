import java.util.*;

public class A373_FindKPairsWithSmallestSums {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k){
        // 创建一个大顶堆
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return (p2.first + p2.second) - (p1.first + p1.second);
            }
        });

        for(int i=0; i<nums1.length; ++i){
            for(int j=0; j<nums2.length; ++j){
                Pair p = new Pair(nums1[i], nums2[j]);
                queue.offer(p);
                if( queue.size()>k){
                    queue.poll();
                }
            }
        }

        List<int[]> ret = new ArrayList<>();
        while (!queue.isEmpty()){
            Pair p = queue.poll();
            int[] tmp = new int[2];
            tmp[0] = p.first;
            tmp[1] = p.second;
            ret.add(tmp);
        }

        Collections.reverse(ret);
        return ret;
    }
}
