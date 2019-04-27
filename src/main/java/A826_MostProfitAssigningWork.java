import javafx.util.Pair;

import java.util.*;

public class A826_MostProfitAssigningWork {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<Pair<Integer, Integer>> jobs = new ArrayList<>();
        int len = difficulty.length, i = 0, res = 0, maxp = 0;
        for (int j = 0; j < len; j++) {
            jobs.add(new Pair<Integer, Integer>(difficulty[i], profit[i]));
        }

        Collections.sort(jobs, Comparator.comparing(Pair::getKey));
        Arrays.sort(worker);

        for(int work : worker){
            while(i < len && work>=jobs.get(i).getKey()){
                maxp = Math.max(maxp, jobs.get(i++).getValue());
            }

            res += maxp;
        }

        return res;
    }

    public static void main(String[] args) {
        A826_MostProfitAssigningWork mostProfitAssigningWork = new A826_MostProfitAssigningWork();
        int[] difficulty = {66,1,28,73,53,35,45,60,100,44,59,94,27,88,7,18,83,18,72,63},
                profit = {66,20,84,81,56,40,37,82,53,45,43,96,67,27,12,54,98,19,47,77},
                worker = {61,33,68,38,63,45,1,10,53,23,66,70,14,51,94,18,28,78,100,16};

        int res = mostProfitAssigningWork.maxProfitAssignment(difficulty, profit, worker);
        System.out.println(res);
    }
}
