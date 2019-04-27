public class Test_A378_KthSmallestElementInASortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 8;
        A378_KthSmallestElementInASortedMatrix kthSmallest = new A378_KthSmallestElementInASortedMatrix();

        System.out.println(kthSmallest.kthSmallest(matrix, k));
    }
}
