public class A190_ReverseBits {
    /**
     * 解题思路：将n从右向左一位一位的取出来，
     * 如果取出来的是1，我们将结果ret左移一位并且加上1；
     * 如果取出来的是0，我们将结果ret左移一位，然后将结果ret左移一位，然后将n右移一位即可。
     */
    // 输出无符号整形
    public int reverseBits(int n){
        int ret = 0;

        for(int i=0; i<32; ++i){
            if( (n & 1) != 0 )
                ret = (ret << 1) + 1;
            else
                ret = ret << 1;
            n = n >> 1;
        }

        return ret;
    }

    public static void main(String[] args) {
        A190_ReverseBits reverseBits = new A190_ReverseBits();
        System.out.println(reverseBits.reverseBits(43261596 ));
    }
}
