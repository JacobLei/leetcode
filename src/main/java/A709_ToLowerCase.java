public class A709_ToLowerCase {
    public String toLowerCase(String str) {
        char[] arr = str.toCharArray();

        for(int i=0; i<arr.length; i++)
            if (arr[i] <= 'Z') {
                arr[i] = (char) (arr[i] + ('a' - 'A'));
            }

        return String.valueOf(arr);
    }
}
