public class A344_ReverseString {
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length-1;

        while(left < right){
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        String str = "hello";
        A344_ReverseString reverseString = new A344_ReverseString();
        String res = reverseString.reverseString(str);
        System.out.println(res);
    }
}
