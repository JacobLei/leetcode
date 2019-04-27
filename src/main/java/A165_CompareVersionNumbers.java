public class A165_CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int pos = 0;
        while(pos < v1.length && pos <v2.length){
            if(Integer.parseInt(v1[pos]) > Integer.parseInt(v2[pos]))
                return 1;
            else if(Integer.parseInt(v1[pos]) < Integer.parseInt(v2[pos]))
                return -1;
            pos++;
        }

        while(pos<v1.length){
            if(Integer.parseInt(v1[pos]) != 0)
                return 1;
            pos++;
        }

        while(pos<v2.length){
            if(Integer.parseInt(v2[pos]) != 0)
                return -1;
            pos++;
        }

        return 0;
    }

    public static void main(String[] args) {
        String version1 = "0.1", version2 = "1.1";
        A165_CompareVersionNumbers compareVersionNumbers = new A165_CompareVersionNumbers();
        int res = compareVersionNumbers.compareVersion(version1, version2);
        System.out.println(res);
    }
}
