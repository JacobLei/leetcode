import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A554_BrickWall {

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> hashMap = new HashMap<>(); // <裂缝处， 频率>
        int maxCnt = 0;
        int res = 0;
        for(List<Integer> list : wall){
            int sum = 0;
            for(int i=0; i<list.size()-1; i++){
                sum += list.get(i);
                int cnt = hashMap.getOrDefault(sum, 0) + 1;
                hashMap.put(sum, cnt);
                maxCnt = Math.max(cnt, maxCnt);
            }
        }

        for(int value : hashMap.values()){
            if(hashMap.get(value) == maxCnt){
                res =  value;
                break;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
    }
}
