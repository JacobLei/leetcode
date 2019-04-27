public class A777_SwapAdjacentinLRString {
    public boolean canTransform(String start, String end){
        int len = start.length();
        int cntL=0, cntR=0;

        for(int i=0; i<len; ++i){
            if(start.toCharArray()[i] == 'R') ++cntR;
            if(end.toCharArray()[i] == 'L') ++cntL;
            if(start.toCharArray()[i] == 'L') --cntL;
            if(end.toCharArray()[i] == 'R') --cntR;
            if(cntL<0 || cntR<0 || cntL*cntR!=0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String start = "XXXLXXXXXX";
        String end = "XXXLXXXXXX";

        A777_SwapAdjacentinLRString swapAdjacentinLRString = new A777_SwapAdjacentinLRString();
        System.out.println(swapAdjacentinLRString.canTransform(start, end));
    }
}
