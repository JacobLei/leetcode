public class A520_DetectCapital {
    public boolean detectCapitalUse(String word) {
        int cnt = 0;

        for(char w : word.toCharArray()){
            if(w <= 'Z')
                cnt++;
        }

        return cnt == 0 || cnt==word.length() || (cnt == 1 && word.charAt(0) <= 'Z');
    }

    public static void main(String[] args) {
        String word = "USA";
        A520_DetectCapital detectCapital = new A520_DetectCapital();
        boolean res = detectCapital.detectCapitalUse(word);
        System.out.println(res);
    }
}
