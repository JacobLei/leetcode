public class A754_ReachaNumber {
    public int reachNumber(int target){
        target = Math.abs(target);
        int res = 0, sum = 0;
        while(sum < target || (sum - target) % 2 == 1){
            sum += ++res;
        }

        return res;
    }

    public static void main(String[] args) {
        A754_ReachaNumber reachaNumber = new A754_ReachaNumber();
        System.out.println(reachaNumber.reachNumber(3));
    }
}
