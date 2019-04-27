public class A5_LongestPalindromicSubstring {
    private int start = 0, maxLen = 0;

    public String longestPalindrome(String s) {
        if (s.length()<2)
            return s;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            extendPalindrome(s, i, i);  // 当为奇数长度时；
            extendPalindrome(s, i, i+1);
        }

        return s.substring(start, start+maxLen);
    }

    private void extendPalindrome(String s, int left, int right) {
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        if(maxLen < right-left-1){
            start = left+1;
            maxLen = right-left-1;
        }
    }

    public static void main(String[] args) {
        String str = "babad";
        A5_LongestPalindromicSubstring palindromicSubstring = new A5_LongestPalindromicSubstring();
        String res = palindromicSubstring.longestPalindrome(str);
        System.out.println(res);
    }
}
