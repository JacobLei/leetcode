import java.util.List;

public class Test_A373_FindKPairsWithSmallestSums {
    public static void main(String[] args) {
        int[] num1 = {1, 1, 2};
        int[] num2 = {1, 2, 3};
        int k = 2;

        A373_FindKPairsWithSmallestSums findKPairs = new A373_FindKPairsWithSmallestSums();

        List<int[]> ret = findKPairs.kSmallestPairs(num1, num2, k);

        for(int[] r : ret){
            for(int i : r){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
