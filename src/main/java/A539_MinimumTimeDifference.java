import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class A539_MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        // 将String格式转化为分钟
        int[] times = new int[timePoints.size()];
        int i = 0, res = 24*60;
        for(String list : timePoints){
            String[] strs = list.split(":");
            times[i++] = Integer.parseInt(strs[0]) * 60 + Integer.parseInt(strs[1]);
        }
        // 将times排序
        Arrays.sort(times);

        for(int j=1; j<i; j++){
            res = (times[j]-times[j-1]) < res ? times[j]-times[j-1] : res;
        }

        return (times[0]+24*60 - times[i-1] < res) ? (times[0]+24*60 - times[i-1]) : res;
    }

    public static void main(String[] args) {
        List<String> timePoints = Arrays.asList("23:59","00:00");
        A539_MinimumTimeDifference difference = new A539_MinimumTimeDifference();
        int res = difference.findMinDifference(timePoints);
        System.out.println(res);
    }
}
