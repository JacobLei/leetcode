import java.util.ArrayList;
import java.util.List;

public class A93_RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s){
        List<String> res = new ArrayList<>();
        restoreIp(s, res, 0, "", 0);
        return res;
    }

    private void restoreIp(String ip, List<String> res, int idx,
                           String restored, int count) {
        if(count > 4) return;
        if(count == 4 && idx==ip.length())
            res.add(restored);
        for(int i=1; i<4; i++){
            if(idx+i > ip.length()) break;
            String s = ip.substring(idx, idx+i);
            if((s.startsWith("0") && s.length()>1) || (i==3 && Integer.parseInt(s)>=256))
                continue;
            restoreIp(ip, res, idx+i, restored+s+(count==3?"":"."), count+1);
        }
    }

    public static void main(String[] args) {
        String s = "25525511135";
        A93_RestoreIPAddresses restoreIPAddresses = new A93_RestoreIPAddresses();
        List<String> res = restoreIPAddresses.restoreIpAddresses(s);

        for (String str : res){
            System.out.print(str + " ");
        }
    }
}
