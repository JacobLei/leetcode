public class A537_ComplexNumberMultiplication {
    public String complexNumberMultiply(String a, String b) {
        int[] valA = getValue(a), valB = getValue(b);
        String real = String.valueOf(valA[0]*valB[0] - valA[1]*valB[1]);
        String img = String.valueOf(valA[0]*valB[1] + valA[1]*valB[0]);

        return real + "+" + img + "i";
    }

    private int[] getValue(String s) {
        String[] strs = s.split("\\+");
        int[] res = new int[2];
        res[0] = Integer.parseInt(strs[0]);
        int index = strs[1].indexOf('i');
        res[1] = Integer.parseInt(strs[1].substring(0, index));
        return res;
    }

    public static void main(String[] args) {
        String a = "1+1i", b = "1+1i";
        A537_ComplexNumberMultiplication multiplication = new A537_ComplexNumberMultiplication();
        String res = multiplication.complexNumberMultiply(a, b);
        System.out.println(res);
    }

}
