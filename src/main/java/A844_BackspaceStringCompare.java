import java.util.Stack;

public class A844_BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {

        return getString(S).equals(getString(T));
    }

    // 从后向前遍历，
    private String getString(String str){
        int n = str.length(), count = 0;
        StringBuilder res = new StringBuilder();
        for (int i = n-1; i >= 0 ; i--) {
            char ch = str.charAt(i);
            if(ch == '#'){
                count++;
            }else{
                if(count>0){
                    count--;
                }else{
                    res.insert(0, ch);
                }
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String S = "ab#c", T = "ad#c";
        A844_BackspaceStringCompare backspaceStringCompare =
                new A844_BackspaceStringCompare();
        boolean res = backspaceStringCompare.backspaceCompare(S, T);
        System.out.println(res);

    }
}
