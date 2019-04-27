import java.util.HashMap;
import java.util.Map;

public class A299_BullsandCows {
    public String getHint(String secret, String guess) {
        int cntRight = 0;
        int cntSum = 0;

        Map<Character, Integer> secretMap = new HashMap<>();    // <字符， 字符出现的次数>
        Map<Character, Integer> guessMap = new HashMap<>();

        for(char c : secret.toCharArray()){
            secretMap.put(c, secretMap.getOrDefault(c, 0)+1);
        }

        // 判断总共猜中多少个数字
        for(char c : guess.toCharArray()){
            if(secretMap.containsKey(c) && secretMap.get(c)>0){
                cntSum++;
                secretMap.put(c, secretMap.get(c)-1);
            }
        }

        // 判断对位的数字有多少个
        char[] secretChar = secret.toCharArray();
        char[] guessChar = guess.toCharArray();

        for(int i=0; i<secretChar.length; i++){
            if(secretChar[i] - guessChar[i] == 0){
                cntRight++;
            }
        }
        return String.valueOf(cntRight) + "A" + String.valueOf(cntSum - cntRight) + "B";
    }

    public static void main(String[] args) {
        String secret = "1807", guess = "7810";
        A299_BullsandCows bullsandCows = new A299_BullsandCows();
        String res = bullsandCows.getHint(secret, guess);
        System.out.println(res);
    }
}
