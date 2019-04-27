public class A43_MultiplyStrings {
    public String multiply(String num1, String num2){
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m+n];

        for (int i=m-1; i>=0; i--){
            for (int j=n-1; j>=0; j--){
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i+j, p2 = i+j+1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }

        StringBuilder res = new StringBuilder();
        for(int p : pos){
            if(!(res.length() == 0 && p == 0))
                res.append(p);
        }

        return res.length() == 0 ? "0" : res.toString();
    }

    public static void main(String[] args) {
        String num1 = "123", num2 = "456";
        A43_MultiplyStrings multiplyStrings = new A43_MultiplyStrings();
        String res = multiplyStrings.multiply(num1, num2);
        System.out.println(res);
    }
}
