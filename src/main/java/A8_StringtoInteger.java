public class A8_StringtoInteger {

    public int myAtoi(String str) {
        // 将字符串转换为字符数组
        char[] ch = str.toCharArray();
        int len = ch.length, index = 0, sign = 1;
        // 注意：这里不能为int类型，需要long类型，目的是为了检查结果是否溢出
        long sum = 0;

        // 去掉开头的空格部分
        while(index<len && ch[index] == ' ') index++;

        // 判断是否为符号位，当为+时，sign=1；当为-时，sign=-1
        if(index < len && (ch[index] == '+' || ch[index] == '-')){
            sign = (ch[index] == '+') ? 1 : -1;
            index++;
        }

        // 遍历字符数组
        while(index < len){
            // 判断是否位数字
            if(ch[index] >= '0' && ch[index] <= '9'){
                sum = sum*10 + ch[index] - '0';
                // 判断结果是否溢出
                if(sign == 1 && sum > Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }else if(sign == -1 && (-1*sum) < Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
                index++;
            }else{  // 如果不是数字，则直接返回
                break;
            }
        }
        return (int)sum * sign;
    }

    public static void main(String[] args) {
        A8_StringtoInteger stringtoInteger = new A8_StringtoInteger();
        String str = "   -42a";
        int res = stringtoInteger.myAtoi(str);
        System.out.println(res);
    }
}
