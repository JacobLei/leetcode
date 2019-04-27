public class A28_ImplementstrStr {
    public int strStr(String haystack, String needle) {
        int lenHaystack = haystack.length(), lenNeedle = needle.length(),
                leftHaystack = 0, rightHaystack = 0, rightNeedle = 0;

        if(lenNeedle == 0){
            return 0;
        }

        while(leftHaystack < lenHaystack - lenNeedle) {
            while (haystack.charAt(rightHaystack) == needle.charAt(rightNeedle)) {
                rightHaystack++;
                rightNeedle++;
                if (rightNeedle == lenNeedle) {
                    return leftHaystack;
                }
            }
            leftHaystack++;
            rightHaystack = leftHaystack;
            rightNeedle = 0;
        }

        return -1;
    }

    public static void main(String[] args) {
        String saystack = "hello", needle = "ll";
        A28_ImplementstrStr implementstrStr = new A28_ImplementstrStr();
        int res = implementstrStr.strStr(saystack, needle);
        System.out.println(res);
    }
}
