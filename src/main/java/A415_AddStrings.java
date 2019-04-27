public class A415_AddStrings {
    public String addStrings(String num1, String num2) {
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int carry = 0, len1 = c1.length-1, len2 = c2.length-1;
        StringBuilder res = new StringBuilder();

        while(len1>= 0 || len2>=0){
            int d1 = (len1 >= 0) ? (c1[len1--] - '0') : 0;
            int d2 = (len2 >= 0) ? (c1[len2--] - '0') : 0;
            int sum = d1 + d2 + carry;
            carry = (sum > 10) ? 1 : 0;
            res.insert(0, sum % 10);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        A415_AddStrings addStrings = new A415_AddStrings();
        String res = addStrings.addStrings("123", "1");

        System.out.println(res);
    }
}
