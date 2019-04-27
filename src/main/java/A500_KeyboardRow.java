import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A500_KeyboardRow {
    public String[] findWords(String[] words) {
        String[] base = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        Map<Character, Integer> map = new HashMap<>(); //<char, rowIndex>
        for(int i=0; i<base.length; i++){
            for(char c : base[i].toCharArray())
                map.put(c, i);
        }

        // 现在还不确定String数组有多大，所以先存放在List中
        List<String> res = new ArrayList<>();
        for(String w : words){
            if(w.equals(""))
                continue;
            int index = map.get(w.toLowerCase().charAt(0));
            for(char c : w.toLowerCase().toCharArray()){
                if(map.get(c) != index){
                    index = -1; // 直接break
                    break;
                }
            }
            if(index != -1) // 如果index不是-1，则是在同一行的单词
                res.add(w);
        }

        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        A500_KeyboardRow keyboardRow = new A500_KeyboardRow();
        String[] res = keyboardRow.findWords(words);
        for(String r : res)
            System.out.print(r + " ");
    }
}
