public class A824_GoatLatin {
    public String toGoatLatin(String S) {
        String ma = "ma";
        StringBuilder res = new StringBuilder(), addA = new StringBuilder("a");
        String[] words = S.split("\\s+");
        for(String word : words){
            StringBuilder tmp = new StringBuilder();
            if(isYuan(word.charAt(0))){
                tmp.append(word).append(ma).append(addA);
            }else{
                tmp.append(word.substring(1)).append(word.charAt(0)).append(ma).append(addA);
            }
            addA.append("a");
            res.append(tmp).append(" ");
        }

        return res.substring(0, res.length()-1);
    }

    private boolean isYuan(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }

    public static void main(String[] args) {
        String str = "I speak Goat Latin";
        A824_GoatLatin goatLatin = new A824_GoatLatin();
        String res = goatLatin.toGoatLatin(str);
        System.out.println(res);
    }
}
