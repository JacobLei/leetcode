import java.util.Comparator;
import java.util.PriorityQueue;

public class A378_KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int i=0; i<matrix.length; ++i){
            for(int j=0; j<matrix[0].length; ++j){
                maxHeap.offer(matrix[i][j]);
                if(maxHeap.size()>k)
                    maxHeap.poll();
            }
        }

        return maxHeap.peek();
    }
}
