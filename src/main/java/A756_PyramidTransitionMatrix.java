import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A756_PyramidTransitionMatrix {

    public boolean pyramidTransition(String bottom, List<String> allowed){

        Map<String, List<String>> map = new HashMap<>();    // key为左右节点的字符串， value：为根结点的集合
        for(String str : allowed){
            String key = str.substring(0,2);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str.substring(2));
        }

        return dfs(map, bottom, new StringBuffer(), 0);
    }

    /**
     *
     * @param map 从allowed构建的key-val对
     * @param bottom    当前层
     * @param nextBottom    上一次
     * @param p     当前层的的位置
     * @return
     */
    private boolean dfs(Map<String, List<String>> map, String bottom, StringBuffer nextBottom, int p) {
        if(p == bottom.length()-1){   // 完成一行，更新bottom和p
            bottom = nextBottom.toString();
            nextBottom = new StringBuffer();
            p = 0;
        }
        if(bottom.length() == 1)
            return true;
        String key = bottom.substring(p, p+2);
        if (map.containsKey(key)) {
            for(String val : map.get(key)){
                nextBottom.append(val);
                if(dfs(map, bottom, nextBottom, p+1))
                    return true;
                nextBottom.setLength(nextBottom.length()-1);    // 回溯
            }
        }


        return false;
    }
}
