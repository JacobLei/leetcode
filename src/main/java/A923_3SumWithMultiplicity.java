import java.util.Arrays;

public class A923_3SumWithMultiplicity {
    private static final int MOOD = 1_000_000_007;
    public int threeSumMulti(int[] A, int target) {
        int res = 0;
        Arrays.sort(A);
        // 定位一个数字
        for (int i = 0; i < A.length - 2; i++) {
            int j = i + 1, k = A.length - 1;    // 定位第二个数字和第三个数字
            while (j < k){
                if(A[j] + A[k] < target - A[i]) ++j;
                else if(A[j] + A[k] > target - A[i]) --k;
                else{
                    if(A[j] == A[k]){   // 如果从j到k都相等，就是组合公式
                        res = (res+(k-j+1) * (k-j)/2) % MOOD;
                        break;
                    }
                    int l = 1, r = 1;
                    while(j+l < k && A[j+l] == A[j]) l++;
                    while(k-r > j && A[k-r] == A[k]) r++;
                    res = (res + l * r) % MOOD;
                    j += l;
                    k -= r;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] A = {1,1,2,2,3,3,4,4,5,5};
        int target = 8;
        A923_3SumWithMultiplicity sumWithMultiplicity = new A923_3SumWithMultiplicity();
        int res = sumWithMultiplicity.threeSumMulti(A, target);
        System.out.println(res);
    }
}
