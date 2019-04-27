import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (scanner.hasNext()) {
            String ipt = scanner.nextLine();
            String[] ipAndMaskCode = ipt.split("/");
            String ip = ipAndMaskCode[0];
            String maskCode = ipAndMaskCode[1];
            // 判断格式
            if (!isValidFormat(ip) || !isValidFormat(maskCode)) {
                System.out.println("ERROR");
            }

            // 判断掩码是否错误
            if (!validMaskCode(maskCode)) {
                System.out.println("ERROR");
            }

            // 判断ip类别， 判断八进制，十进制，十六进制
            String fnStr = ip.substring(0, ip.indexOf("."));

            // 判断是否是八进制
            if(Pattern.compile("[0*]").matcher(fnStr).matches()){

            }else if(Pattern.compile("[0x*]").matcher(fnStr).matches()){    // 判断是否是十六进制

            }else{

            }

//            int fn = Integer.valueOf(fnStr);
        }
    }

    /**
     * 判断ip和掩码是否是xxx.xxx.xxx.xxx格式Ø
     *
     * @param ip
     * @return
     */
    private static boolean isValidFormat(String ip) {
        boolean res = true;
        if (ip == null || "".equals(ip))
            return false;
        Pattern pattern = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)$");
        Matcher matcher = pattern.matcher(ip);

        if (matcher.matches()) {
            String[] nums = ip.split("\\.");
            for (String num : nums) {
                int n = Integer.valueOf(num);
                if (n < 0 || n > 255) {
                    res = false;
                    break;
                }
            }
        } else {
            res = false;
        }

        return res;
    }

    /**
     * 判断掩码是否是前面全为1后面全为0 的格式
     *
     * @param maskCode
     * @return
     */
    private static boolean validMaskCode(String maskCode) {
        boolean res = true;
        String[] nums = maskCode.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (String num : nums) {
            int n = Integer.valueOf(num);
            sb.append(binaryString(n));
        }
        int firstIndexOf0 = sb.indexOf("0");
        int lastIndexOf1 = sb.lastIndexOf("1");
        if (firstIndexOf0 < lastIndexOf1) {
            res = false;
        }
        return res;
    }

    /**
     * 将整数转成对应的八位二进制字符串
     * @param num
     * @return
     */
    private static String binaryString(int num) {
        StringBuilder result = new StringBuilder();
        int flag = 1 << 7;
        for (int i = 0; i < 8; i++) {
            int val = (flag & num) == 0 ? 0 : 1;
            result.append(val);
            num <<= 1;
        }
        return result.toString();
    }

}
