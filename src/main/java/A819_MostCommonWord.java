import java.util.*;

public class A819_MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> cnt = new HashMap<>();
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split("\\s+");
        for(String w : words)
            if(!bannedSet.contains(w))
                cnt.put(w, cnt.getOrDefault(w, 0) + 1);
        return Collections.max(cnt.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
       String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
       String[] banned = {"hit"};
       A819_MostCommonWord mostCommonWord = new A819_MostCommonWord();
       String res = mostCommonWord.mostCommonWord(paragraph, banned);
        System.out.println(res);
    }
}
