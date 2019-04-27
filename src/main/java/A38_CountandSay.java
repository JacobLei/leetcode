public class A38_CountandSay {
    public String countAndSay(int n) {
        if(n<1)
            return "";
        String res = "1";
        while(--n > 0){
            String cur = "";
            for(int i=0; i<res.length(); i++){
                int cnt = 1;
                while(i < res.length()-1 && res.charAt(i) == res.charAt(i+1)){
                    cnt++;
                    i++;
                }
                cur += Integer.toString(cnt) + res.charAt(i);
            }

            res = cur;
        }

        return res;
    }

    public static void main(String[] args) {
        A38_CountandSay countandSay = new A38_CountandSay();
        String res = countandSay.countAndSay(4);
        System.out.println(res);
    }
}
