class MagicDictionary {
    private class TrieNode{
        TrieNode[] children;
        boolean isEnd;

        TrieNode(){
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    TrieNode root;

    public MagicDictionary(){
        root = new TrieNode();
    }

    /**
     * Build a dictionary through a list of words.
     * @param dict 字典集
     */
    public void buildDict(String[] dict){
        for(String str : dict){
            TrieNode node = root;
            for(char c : str.toCharArray()){
                if(node.children[c-'a']==null){
                    node.children[c-'a'] = new TrieNode();
                }
                node = node.children[c-'a'];
            }
            node.isEnd = true;
        }
    }

    /**
     * 查询是否只有替换一个单词的word
     * @param word
     * @return
     */
    public boolean search(String word){
        char[] arr = word.toCharArray();
        for(int i=0; i<word.length(); ++i){
            for(char c='a'; c<='z'; c++){
                if(arr[i] == c)         // 避免原字符串搜索
                    continue;
                char org = arr[i];
                arr[i] = c;
                if(helper(new String(arr), root)){
                    return true;
                }
                arr[i] = org;
            }
        }

        return false;
    }

    private boolean helper(String s, TrieNode root) {
        TrieNode node = root;
        for(char c : s.toCharArray()){
            if(node.children[c-'a'] == null)
                return false;
            node = node.children[c-'a'];
        }
        return node.isEnd;
    }

    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        String[] dict = {"hello", "leetcode"};
        magicDictionary.buildDict(dict);
        System.out.println(magicDictionary.search("hello"));
        System.out.println(magicDictionary.search("hhllo"));
        System.out.println(magicDictionary.search("hell"));
        System.out.println(magicDictionary.search("leetcoded"));
    }
}
