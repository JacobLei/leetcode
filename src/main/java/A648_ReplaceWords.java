
import java.util.LinkedList;
import java.util.List;

public class A648_ReplaceWords {
    public String replaceWords(List<String> dict, String sentence){
        String[] tokens = sentence.split(" ");
        TrieNode tire = buildTire(dict);            // 构建字典树
        return replaceWords(tokens, tire);
    }

    private class TrieNode {
        char val;
        TrieNode[] children;
        boolean isEnd;

        public TrieNode(char val){
            this.val = val;
            this.children = new TrieNode[26];
            this.isEnd = false;
        }
    }
    // 构建字典树
    private TrieNode buildTire(List<String> dict){
        TrieNode root = new TrieNode(' ');
        for(String word : dict){
            TrieNode tmp = root;
            for(char c : word.toCharArray()){
                if(tmp.children[c - 'a'] == null)
                    tmp.children[c - 'a'] = new TrieNode(c);
                tmp = tmp.children[c - 'a'];
            }
            tmp.isEnd = true;
        }
        return root;
    }

    // 将单词进行前缀替换
    private String getShortestReplacement(String token, TrieNode root){
        TrieNode temp = root;
        StringBuilder stringBuilder = new StringBuilder();
        for(char c : token.toCharArray()){
            stringBuilder.append(c);
            if(temp.children[c-'a'] != null){
                if(temp.children[c-'a'].isEnd)
                    return stringBuilder.toString();
                temp = temp. children[c-'a'];
            }else {
                return token;
            }
        }
        return token;
    }

    private String replaceWords(String[] tokens, TrieNode root){
        StringBuilder stringBuilder = new StringBuilder();
        for(String token : tokens){
            stringBuilder.append(getShortestReplacement(token, root));
            stringBuilder.append(" ");
        }
        return stringBuilder.substring(0, stringBuilder.length()-1);
    }


    public static void main(String[] args) {
        List<String> dict = new LinkedList<>();
        dict.add("cat");
        dict.add("bat");
        dict.add("rat");
        String sentence = "the cattle was rattled by the battery";
        A648_ReplaceWords words = new A648_ReplaceWords();
        System.out.println(words.replaceWords(dict, sentence));
    }
}
