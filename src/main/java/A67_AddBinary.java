public class A67_AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int lenA = a.length()-1, lenB = b.length()-1, carray = 0;
        while(lenA>=0 || lenB>=0){
            int cA = (lenA>=0) ? a.charAt(lenA--) - '0' : 0;
            int cB = (lenB>=0) ? b.charAt(lenB--) - '0' : 0;
            int sum = cA + cB + carray;
            carray = (sum > 1) ? 1 : 0;
            res.insert(0, sum % 2);
        }
        if(carray == 1)
            res.insert(0, 1);
        return res.toString();
    }

    public static void main(String[] args) {
        String a = "1101", b = "1";
        A67_AddBinary addBinary = new A67_AddBinary();
        System.out.println(addBinary.addBinary(a, b));
    }
}
