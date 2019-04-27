public class A125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        s = s.toLowerCase();
        while(left <right ){
            while(left < right && !isWord(s.charAt(left))){
                left++;
            }
            while(left < right && !isWord(s.charAt(right))){
                right--;
            }
            if(s.charAt(left++) != s.charAt(right--)){
                return false;
            }
        }

        return true;
    }

    private boolean isWord(char ch){
        return (ch>='a' && ch<='z') || (ch>='0' && ch<='9');
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        A125_ValidPalindrome validPalindrome = new A125_ValidPalindrome();
        boolean res = validPalindrome.isPalindrome(s);
        System.out.println(res);
    }
}
