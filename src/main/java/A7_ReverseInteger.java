public class A7_ReverseInteger {

    public int reverse(int x) {
        // 注意这里为long类型，防止int类型的则行数反转后溢出
        long res = 0;

        // 反转整数
        while(x != 0){
            // 获取到最低位
            res = res * 10 + x % 10;
            // 在原数字上移除最低位
            x /= 10;

            // 判断是否溢出，若溢出则返回0
            if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
                return 0;
        }

        return (int)res;
    }

    public static void main(String[] args) {
        int num = -123;
        A7_ReverseInteger reverseInteger = new A7_ReverseInteger();
        int res = reverseInteger.reverse(num);
        System.out.println(res);
    }
}
