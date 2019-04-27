public class Test_A71_SimplifyPath {
    public static void main(String[] args) {
        A71_SimplifyPath simplifyPath = new A71_SimplifyPath();
        String path = "/a/./b/../../c/";

        String ret = simplifyPath.simplifyPath(path);
        System.out.println(ret);
    }
}
