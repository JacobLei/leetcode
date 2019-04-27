public class A443_StringCompression {
    // 字符串的双指针
    public int compress(char[] chars) {
        int indexAns = 0, index = 0;

        while(index < chars.length){
            char curChar = chars[index];
            int cnt = 0;
            while(index < chars.length && chars[index] == curChar){
                index++;
                cnt++;
            }
            chars[indexAns++] = curChar;
            if(cnt == 1)
                continue;
            for(char c : Integer.toString(cnt).toCharArray()){
                chars[indexAns++] = c;
            }
        }

        return indexAns;
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'b', 'c', 'c', 'c'};
        A443_StringCompression stringCompression = new A443_StringCompression();
        int res = stringCompression.compress(chars);
        System.out.println(res);
    }
}
