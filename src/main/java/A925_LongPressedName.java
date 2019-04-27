public class A925_LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        if(name == null || typed == null)
            return false;
        int p1 = 0, p2 = 0;

        while(p1<name.length() && p2<typed.length()){
            int k1 = 0, k2 = 0, pp1 = p1, pp2 = p2;
            while(pp1 < name.length() && name.charAt(p1) == name.charAt(pp1)){
                k1++;
                pp1++;
            }
            while(pp2 < typed.length() && typed.charAt(p2) == typed.charAt(pp2)){
                k2++;
                pp2++;
            }
            if(name.charAt(p1) != typed.charAt(p2) || k1 < k2){
                return false;
            }
            p1 = pp1;
            p2 = pp2;
        }

        return true;
    }

    public static void main(String[] args) {
        String name = "alex", typed = "aaleex";
        A925_LongPressedName pressedName = new A925_LongPressedName();
        boolean res = pressedName.isLongPressedName(name, typed);
        System.out.println(res);
    }
}
