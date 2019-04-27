import java.util.Arrays;

public class A556_NextGreaterElementIII {
    public int nextGreaterElement(int n) {
        char[] number = String.valueOf(n).toCharArray();

        int i, j;
        for (i=number.length-1; i>0; i--){ // 从右向左遍历，找到第一个降序的索引
            if (number[i-1]<number[i])
                break;
        }
        if (i == 0)     // 从右向左遍历，整个数组都为升序，则返回-1
            return -1;
        int x = number[i-1], smallest = i;  // x为需要交换的值
        for (j=i+1; j<number.length; j++){
            if(number[j]>x && number[j]<=number[smallest])
                smallest = j;
        }

        char tmp = number[i-1];
        number[i-1] = number[smallest];
        number[smallest] = tmp;

        Arrays.sort(number, i, number.length);

        long val = Long.parseLong(new String(number));
        return (val <= Integer.MAX_VALUE) ? (int)val : -1;
    }

    public static void main(String[] args) {
        A556_NextGreaterElementIII nextGreaterElementIII = new A556_NextGreaterElementIII();
        int res = nextGreaterElementIII.nextGreaterElement(12);
        System.out.println(res);
    }
}
