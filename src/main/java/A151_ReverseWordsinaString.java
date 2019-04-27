import java.util.Stack;

public class A151_ReverseWordsinaString {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        String[] arr = s.trim().split("\\s+");
        Stack<String> stack = new Stack<>();
        for(String str : arr){
            stack.push(str);
        }

        while(!stack.empty()){
            res.append(stack.pop()).append(" ");
        }

        return res.toString().trim();
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        A151_ReverseWordsinaString reverseWordsinaString = new A151_ReverseWordsinaString();
        String res = reverseWordsinaString.reverseWords(s);
        System.out.println(res);
    }
    

}
