import java.util.HashMap;
import java.util.Map;

public class A166_FractiontoRecurringDecimal {
    public String fractionToDecimai(int numerator, int denominator){
        if(numerator == 0)
            return "0";

        StringBuilder res = new StringBuilder();
        // 确定符号为
        int symbolNumerator = numerator > 0 ? 1 : -1;
        int symbolDenominator = denominator > 0 ? 1 : -1;
        res.append((symbolNumerator*symbolDenominator < 0) ? "-" : "");
        // 将值取绝对值
        // 由于整型数INT的取值范围是-2147483648～2147483647，
        // 而对-2147483648取绝对值就会超出范围，
        // 所以我们需要先转为long long型再取绝对值。
        long num = Math.abs((long) numerator);
        long den = Math.abs((long)denominator);

        // 整数部分
        res.append(num / den);
        num %= den;
        // 当余数部分为0
        if(num == 0){
            return res.toString();
        }

        // 当余数部分不为0
        res.append(".");
        Map<Long, Integer> hashMap = new HashMap<>();
            hashMap.put(num, res.length());
        while(num != 0){    // 当小数部分不为0
            // 取小数的一位
            num *= 10;
            res.append(num/den);
            num %= den;
            // 当小数这一位已经出现过
            if(hashMap.containsKey(num)){
                int index = hashMap.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            }else{
                hashMap.put(num, res.length());
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        A166_FractiontoRecurringDecimal recurringDecimal = new A166_FractiontoRecurringDecimal();
        System.out.println(recurringDecimal.fractionToDecimai(2, 3));
    }
}
