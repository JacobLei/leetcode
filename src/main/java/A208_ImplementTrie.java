public class A208_ImplementTrie {

    private TireNode root;

    /**
     * 初始化前缀树
     */
    public A208_ImplementTrie(){
        root = new TireNode();
    }

    /**
     * 将word插入前缀树
     * @param word
     */
    public void insert(String word){
        TireNode put = root;
        for(int i=0; i<word.length(); ++i){
            int index = word.charAt(i) - 'a';    // 对应数组的位置
            if(put.children[i] == null){
                put.children[index] = new TireNode();   // 在index位置创建相应的结点，即该结点的隐含信息为该index所对应的字符
            }
            put = put.children[index];
        }
        put.isEnd = true;       // 标记这个结点为尾结点
    }

    /**
     *  查找该word是否在字典树中
     * @param word
     * @return
     */
    public boolean search(String word){
        TireNode node = find(word);
        return node != null && node.isEnd;
    }

    /**
     * 判断是否有以prefix开头的单词
     * @param prefix
     * @return
     */
    public boolean startWith(String prefix){
        TireNode node = find(prefix);
        return node != null;
    }

    /**
     *  查找字典树中是否有prefix,如果有，返回最后一个结点，如果没有返回null
     * @param prefix
     * @return
     */
    public TireNode find(String prefix){
        TireNode node = root;
        for(int i=0; i<prefix.length(); ++i){
            int index = prefix.charAt(i) - 'a';
            if(node.children[index] == null)
                return null;
            node = node.children[index];
        }
        return node;
    }

    public static void main(String[] args) {
        A208_ImplementTrie implementTrie = new A208_ImplementTrie();

        implementTrie.insert("apple");
        System.out.println(implementTrie.search("apple"));
        System.out.println(implementTrie.search("app"));
        System.out.println(implementTrie.startWith("app"));
        implementTrie.insert("app");
        System.out.println(implementTrie.search("app"));
    }
}
