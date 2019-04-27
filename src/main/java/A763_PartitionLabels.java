import java.util.LinkedList;
import java.util.List;

public class A763_PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new LinkedList<>();
        if(S == null || S.length() == 0)
            return res;

        int[] map = new int[26];    // 保存<char, lastPostion>

        for(int i=0; i<S.length(); i++){
            map[S.charAt(i) - 'a'] = i;
        }

        // 记录字符串的start 和 last 位置
        int last = 0, start = 0;
        for(int i=0; i<S.length(); i++){
            last = Math.max(last, map[S.charAt(i) - 'a']);
            if(i == last){
                res.add(last - start + 1);
                start = last + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        A763_PartitionLabels partitionLabels = new A763_PartitionLabels();
        List<Integer> res = partitionLabels.partitionLabels(S);

        for(int r : res){
            System.out.println(r);
        }
    }
}
