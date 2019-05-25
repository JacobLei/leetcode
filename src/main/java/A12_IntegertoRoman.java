public class A12_IntegertoRoman {

    public String intToRoman(int num) {
        // 这里使用StringBuilder保存转换后的罗马数， 注意：这里有一个java面试的考点：Java中String、StringBuilder以及StringBuffer的比较
        StringBuilder res = new StringBuilder();
        // 用数组保存整数区间及其对应的罗马数区间
        int[] n = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] str = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for(int i=0; i<n.length; i++){
            // 判断该整数属于哪一个区间
            while(num >= n[i]){
                // 找到区间数后，计算剩余数
                num -= n[i];
                // 添加区间数对应的罗马数
                res.append(str[i]);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        A12_IntegertoRoman  integertoRoman = new A12_IntegertoRoman();
        String res = integertoRoman.intToRoman(58);
        System.out.println(res);
    }

}
