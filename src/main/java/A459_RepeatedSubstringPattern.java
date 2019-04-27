public class A459_RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        // 重复的子串一定在0—mid之间
        for (int i = len / 2; i >= 1 ; i--) {
            if(len % i == 0){   // 判断该字符串是否为i的倍数
                int l = len / i;
                String sub = s.substring(0, i);
                StringBuilder t = new StringBuilder();
                for(int j=0; j<l; j++){
                    t.append(sub);
                }
                if(t.toString().equals(s)) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String s = "abab";
        A459_RepeatedSubstringPattern substringPattern = new A459_RepeatedSubstringPattern();
        boolean res = substringPattern.repeatedSubstringPattern(s);
        System.out.println(res);
    }
}
