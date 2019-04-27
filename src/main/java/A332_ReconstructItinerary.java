import java.util.*;

public class A332_ReconstructItinerary {

    Map<String, PriorityQueue<String>> hashMap = new HashMap<>();
    LinkedList<String> path = new LinkedList<>();

    public List<String> findItinerary(String[][] tickets){
        if(tickets == null)
            return path;
        // 构建邻接矩阵
        for(String[] ticket : tickets){
            hashMap.putIfAbsent(ticket[0], new PriorityQueue<>());
            hashMap.get(ticket[0]).add(ticket[1]);
        }
        visit("JFK");
        return path;
    }

    private void visit(String airport) {
        PriorityQueue<String> queue = hashMap.get(airport);

        while(queue != null && !queue.isEmpty()){
            visit(queue.poll());
        }
        path.addFirst(airport);
    }


    public static void main(String[] args) {
        String[][] input = {{"MUC", "LHR"}, {"JFK", "MUC"},
                {"SFO", "SJC"}, {"LHR", "SFO"}};
        A332_ReconstructItinerary reconstruct = new A332_ReconstructItinerary();
        List<String> ret = reconstruct.findItinerary(input);

        for(String s : ret){
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
