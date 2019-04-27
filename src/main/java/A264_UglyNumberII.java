import java.util.LinkedList;
import java.util.List;

public class A264_UglyNumberII {
    public int nthUglyNumber(int n){
        int[] ret = new int[n];
        ret[0] = 1;
        int ind2 = 0;
        int ind3 = 0;
        int ind5 = 0;

        for(int i=1; i<n; ++i){
            int min = Math.min(ret[ind2]*2,
                    Math.min(ret[ind3]*3, ret[ind5]*5));
            if(ret[ind2]*2 == min) ind2++;
            if(ret[ind3]*3 == min) ind3++;
            if(ret[ind5]*5 == min) ind5++;
            ret[i] = min;
        }
        return ret[n-1];
    }
}
