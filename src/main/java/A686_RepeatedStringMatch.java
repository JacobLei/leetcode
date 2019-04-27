public class A686_RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder();
        sb.append(A);
        int res = 1;
        while(sb.indexOf(B) < 0){
            if(sb.length() - A.length() > B.length()){
                return -1;
            }
            sb.append(A);
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        String A = "abcd", B = "cdabcdab";
        A686_RepeatedStringMatch stringMatch = new A686_RepeatedStringMatch();
        int res = stringMatch.repeatedStringMatch(A, B);
        System.out.println(res);
    }
}
