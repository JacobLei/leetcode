public class TireNode {
    public TireNode[] children;
    public boolean isEnd;

    public TireNode(){
        children = new TireNode[26];
        isEnd = false;
    }
}
