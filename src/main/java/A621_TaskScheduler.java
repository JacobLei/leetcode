import java.lang.reflect.Array;
import java.util.Arrays;

public class A621_TaskScheduler {
    public int leaseInterval(char[] tasks, int n){
        int[] c = new int[26];

        for(char t : tasks){
            c[t-'A']++;
        }

        Arrays.sort(c);

        int i = 25;
        while(i >= 0 && c[i] == c[25]) i--;

        return (c[25]-1) * (n+1) + (25-i);
    }

    public static void main(String[] args) {
        A621_TaskScheduler taskScheduler = new A621_TaskScheduler();
        String tasks = "AAABBB";
        System.out.println(taskScheduler.leaseInterval(tasks.toCharArray(), 2));
    }
}
