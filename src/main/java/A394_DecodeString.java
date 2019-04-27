import java.util.Stack;

public class A394_DecodeString {

    public String decodeString(String s){
        Stack<Integer> stInt = new Stack<Integer>();
        Stack<String> stStr = new Stack<String>();
        String ret = "";
        int cnt = 0;
        for(int i=0; i<s.length(); ++i){
            char c = s.charAt(i);
            if(c>='0' && c<='9'){
                cnt = cnt * 10 + (c - '0');
            }else if( c == '['){
                stInt.push(cnt);
                stStr.push(ret);
                cnt = 0;
                ret = "";
            } else if (c == ']') {
                int len = stInt.pop();
                StringBuffer temp = new StringBuffer(stStr.pop());
                for(int j=0; j<len; ++j){
                    temp.append(ret);
                }
                ret = temp.toString();
            }else{
                ret += c;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        String s = "3[a2[c]]";
        A394_DecodeString decodeString = new A394_DecodeString();
        System.out.println(decodeString.decodeString(s));
    }
}
