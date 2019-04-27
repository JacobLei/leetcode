import java.util.*;

public class A347_TopKFrequentElements {
    public List<Integer> topKFrequenetElements(int[] nums, int k){
        // 计算每一个元素的频率
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums){
//            if(map.containsKey(num)){
//                map.put(num, map.get(num)+1);
//            }else{
//                map.put(num, 1);
//            }
            map.put(num, map.getOrDefault(num, 1) + 1);
        }

        // 创建一个小顶堆
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.second - o2.second;
            }
        });

        // 维持堆中有k个元素
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            Pair p = new Pair(entry.getKey(), entry.getValue());
            queue.offer(p);
            if(queue.size() > k)
                queue.poll();
        }

        // 从堆中获取所有的元素
        List<Integer> ret = new ArrayList<Integer>();
        while(!queue.isEmpty()){
            ret.add(queue.poll().first);
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5};
        int k = 3;

        A347_TopKFrequentElements topK = new A347_TopKFrequentElements();
        List<Integer> ret = topK.topKFrequenetElements(nums, k);

        for(Integer r : ret)
            System.out.println(r);
    }
}
