public class A930_BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] A, int S) {
        int res = 0, len = A.length, psum = 0;
        int[] count = new int[len+1];
        count[0] = 1;
        for(int i : A){
            psum += i;
            if(psum>=S){
                res += count[psum-S];
            }
            count[psum]++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1, 0, 1, 0, 1};
        int S = 2;
        A930_BinarySubarraysWithSum subarraysWithSum = new A930_BinarySubarraysWithSum();
        int res = subarraysWithSum.numSubarraysWithSum(A, S);
        System.out.println(res);
    }
}
