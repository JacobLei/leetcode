import java.util.HashMap;
import java.util.Map;

class MapSum {

    class TrieNode{
        Map<Character, TrieNode> children;
        boolean isWord;
        int value;

        TrieNode(){
            children = new HashMap<Character, TrieNode>();
            isWord = false;
            value = 0;
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode node = root;
        for(char c : key.toCharArray()){
            TrieNode next = node.children.get(c);
            if(next == null){
                next = new TrieNode();
                node.children.put(c, next);
            }
            node = next;
        }
        node.isWord = true;
        node.value = val;
    }

    public int sum(String prefix) {
        TrieNode node = root;
        for(char c : prefix.toCharArray()){
            TrieNode next = node.children.get(c);
            if(next == null)
                return 0;
            node = next;
        }
        return dfs(node);
    }

    /**
     * dfs求和
     * @param node
     * @return
     */
    private int dfs(TrieNode node) {
        int sum = 0;
        for(char c : node.children.keySet()){
            sum += dfs(node.children.get(c));
        }
        return sum + node.value;
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));
    }
}
