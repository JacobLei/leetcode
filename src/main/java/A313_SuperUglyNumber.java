public class A313_SuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes){
        int[] ret =  new int[n];
        ret[0] = 1;
        int[] cnt = new int[primes.length];

        for(int i=1; i<n; ++i){
            int min = ret[cnt[0]] * primes[0];
            for(int j=1; j<primes.length; ++j){
                min = Math.min(min, ret[cnt[j]] * primes[j]);
            }

            for(int j=0; j<primes.length; ++j){
                if(min == ret[cnt[j]] * primes[j]){
                    cnt[j]++;
                }
            }
            ret[i] = min;
        }

        return ret[n-1];
    }

}
