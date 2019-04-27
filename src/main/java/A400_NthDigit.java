public class A400_NthDigit {

     public int findNthDigit(int n){
         long m = n, digitType = 1, digitNum = 9, start = 1;

         // 定位到几位数
         while(n > digitType*digitNum){
             n -= (int)digitType*digitNum;
             digitType++;
             digitNum *= 10;
             start *= 10;
         }

         // 定位到是具体的哪个数
         start += (n-1)/digitType;
         return String.valueOf(start).charAt((int)((n-1)%digitType)) - '0';
     }

    public static void main(String[] args) {
        A400_NthDigit nthDigit = new A400_NthDigit();
        System.out.println(nthDigit.findNthDigit(11));
    }
}
