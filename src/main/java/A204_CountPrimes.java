public class A204_CountPrimes {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];    // 初始化大小为n的数组，初始值为false
        int res = 0;
        for(int i=2; i<n; i++){
            if(!notPrime[i]){                       // 如果为false
                res++;
                for (int j = 2; i*j < n; j++) {     // 将该数后面的倍数标记为true
                    notPrime[i*j] = true;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        A204_CountPrimes primes = new A204_CountPrimes();
        int res = primes.countPrimes(10);
        System.out.println(res);
    }
}
