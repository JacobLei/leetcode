public class A541_ReverseStringII {

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();

        for(int i=0; i<chars.length; i = i + 2 * k){
            swap(chars, i, Math.min(i+k-1, chars.length-1));
        }

        return String.valueOf(chars);
    }

    private void swap(char[] chars, int l, int r) {
        while(l < r){
            char tmp = chars[l];
            chars[l++] = chars[r];
            chars[r--] = tmp;
        }
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        A541_ReverseStringII reverseString = new A541_ReverseStringII();
        String res = reverseString.reverseStr(s, k);
        System.out.println(res);
    }
}
