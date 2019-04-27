import java.util.Arrays;

public class A881_BoatstoSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        int res = 0, left = 0, right = people.length-1;

        Arrays.sort(people);
        while(left <= right){
            if(people[left] + people[right] <= limit){
                left++;
                right--;
            }else{
                right--;
            }
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] people = {1, 2, 2, 3};
        int limit = 3;
        A881_BoatstoSavePeople boatstoSavePeople = new A881_BoatstoSavePeople();
        int res = boatstoSavePeople.numRescueBoats(people,limit);
        System.out.println(res);
    }
}
