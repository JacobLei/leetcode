public class A13_RomantoInteger {

    public int romanToInt(String s) {
        // 初始化七种字符出现的次数为0
        int I = 0, V = 0, X = 0, L = 0, C = 0, D = 0, M = 0;


        // 遍历字符串，统计每种字符串出现的次数
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'I'){
                if(i+1<s.length() && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X'))
                    I--;
                else
                    I++;
            }else if(s.charAt(i) == 'V'){
                V++;
            }else if(s.charAt(i) == 'X'){
                if(i+1<s.length() && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C'))
                    X--;
                else
                    X++;
            }else if(s.charAt(i) == 'L'){
                L++;
            }else if(s.charAt(i) == 'C'){
                if(i+1<s.length() && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M'))
                    C--;
                else
                    C++;
            }else if(s.charAt(i) == 'D'){
                D++;
            }else if(s.charAt(i) == 'M'){
                M++;
            }
        }

        return I + V*5 + X*10 + L*50 + C*100 + D*500 + M*1000;
    }

    public static void main(String[] args) {
        A13_RomantoInteger romantoInteger = new A13_RomantoInteger();
        String str = "MCMXCIV";
        int res = romantoInteger.romanToInt(str);
        System.out.println(res);
    }
}
