public class A69_Sqrtx {
    public int mySqrt(int x) {
       if(x <= 1)
           return x;
        int left = 0, right = x;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(x / mid >= mid) left = mid + 1;
            else right = mid;
        }

        return right - 1;
    }

    public static void main(String[] args) {
        A69_Sqrtx sqrtx = new A69_Sqrtx();
        System.out.println(sqrtx.mySqrt(4));
    }
}
