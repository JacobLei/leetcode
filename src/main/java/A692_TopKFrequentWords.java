import java.util.*;

public class A692_TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k){
        List<String> ret = new ArrayList<>();
        Map<String, Integer> hashMap = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> minHeap =
                new PriorityQueue<Map.Entry<String, Integer>>(new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        if( o2.getValue() - o1.getValue() == 0)
                            return o2.getKey().compareTo(o1.getKey());
                        return o1.getValue() - o2.getValue();
                    }
                });

        for(String w : words)
            hashMap.put(w, hashMap.getOrDefault(w, 0)+1);

        for(Map.Entry<String, Integer> entry : hashMap.entrySet()){
            minHeap.offer(entry);
            if(minHeap.size()>k)
                minHeap.poll();
        }

        while(!minHeap.isEmpty()){
            ret.add(minHeap.poll().getKey());
        }
        Collections.reverse(ret);
        return ret;
    }

    public static void main(String[] args) {
        A692_TopKFrequentWords topKFrequentWords = new A692_TopKFrequentWords();
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;

        List<String> ret = new ArrayList<>();
        ret = topKFrequentWords.topKFrequent(words, k);

//        for(String r : ret)
//            System.out.println(r);

        System.out.println("~0<<2 = " +  (~0<<2));
        System.out.println("1<<2 = " + (1<<2));
        System.out.println("~(0<<2) = " + (~(0<<2)));
        System.out.println("~1<<2 = " + (~1<<2));

    }

}
