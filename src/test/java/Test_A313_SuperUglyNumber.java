public class Test_A313_SuperUglyNumber {
    public static void main(String[] args) {
        int n = 12;
        int[] primes = {2, 7, 13, 19};

        A313_SuperUglyNumber superUglyNumber = new A313_SuperUglyNumber();
        System.out.println(superUglyNumber.nthSuperUglyNumber(n, primes));
    }
}
