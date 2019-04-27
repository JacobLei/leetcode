public class Test_A150_EvaluateReversePolishNotation {

    public static void main(String[] args) {
        A150_EvaluateReversePolishNotation erpn = new A150_EvaluateReversePolishNotation();
        String[] exp = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};

        System.out.println(erpn.evalRPN(exp));
    }
}
