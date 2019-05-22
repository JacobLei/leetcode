public class A9_PalindromeNumber {


    public boolean isPalindrome1(int x) {

        // 将整数转化为字符数组
        char[] str = String.valueOf(x).toCharArray();
        // 创建左右指针
        int left = 0, right = str.length-1;
        // 遍历字符串
        while(left < right){
            // 如果左指针指向的字符与右指针指向的字符不同时，直接返回false
            if (str[left] != str[right])
                return false;
            left++;
            right--;
        }

        return true;
    }

    public boolean isPalindrome2(int x) {

        // 排除负数和以0结尾的整数（除0以外）
        if ((x < 0) || (x % 10 == 0 && x != 0 ))
            return false;

        int reverNum = 0;
        // 翻转整数过程
        while (x > reverNum){
            reverNum = reverNum * 10 + x % 10;  // 计算翻转数字
            x /= 10;                            // 计算剩余数字
        }

        return reverNum == x || reverNum / 10 == x; // reverNum == x为整数位数偶数个时的判断条件；reverNum / 10 == x为整数位数奇数个时的判断条件
    }

    public static void main(String[] args) {
        int x = 1221;
        A9_PalindromeNumber palindromeNumber = new A9_PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome1(x));
        System.out.println(palindromeNumber.isPalindrome2(x));
    }
}
