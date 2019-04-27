public class A6_ZigZagConversion {
    public String convert(String s, int nRows){
        char[] arr = s.toCharArray();
        StringBuilder[] sb = new StringBuilder[nRows];
        for(int i=0; i<nRows; i++){
            sb[i] = new StringBuilder();
        }
        int index = 0, len = arr.length;

        while(index<len){
            for (int i = 0; i < nRows && index<len; i++) {
                sb[i].append(arr[index++]);
            }
            for (int i = nRows-2; i >=1 && index<len; i--) {
                sb[i].append(arr[index++]);
            }
        }

        for (int i = 1; i < nRows; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int nRows = 3;
        A6_ZigZagConversion conversion = new A6_ZigZagConversion();
        String res = conversion.convert(s, nRows);
        System.out.println(res);
    }
}
