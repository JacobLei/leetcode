import java.util.HashSet;
import java.util.Set;

public class A202_HappyNumber {

    public boolean isHappy(int n) {
        // 集合保存出现过的数
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(n);

        // 循环判断n是否为1
        while(n != 1){
            char[] tmp = String.valueOf(n).toCharArray();
            n = 0;
            for(char c : tmp){
                n += (c - '0') * (c - '0');
            }
            if(!hashSet.add(n)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        A202_HappyNumber happyNumber = new A202_HappyNumber();
        boolean res= happyNumber.isHappy(22);
        System.out.println(res);
    }
}
