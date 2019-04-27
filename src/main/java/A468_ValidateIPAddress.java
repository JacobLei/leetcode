public class A468_ValidateIPAddress {
    public String validIPAddress(String IP){
        if(isValidIPv4(IP))
            return "IPv4";
        else if(isValidIPv6(IP))
            return "IPv6";
        else
            return "Neither";
    }

    private boolean isValidIPv6(String ip) {
        int cnt = 0;
        for (int i = 0; i < ip.length(); i++) {
            if(ip.charAt(i) == ':')
                cnt++;
        }
        String[] tokens = ip.split(":");
        if(cnt!=7 || tokens.length!=8)
            return false;

        for(String token : tokens){
            if (token.length()>4 || token.length()<1)
                return false;
            for (int i = 0; i < token.length(); i++) {
                if(token.charAt(i)>='a' && token.charAt(i)<='f'
                        || token.charAt(i)>='A' && token.charAt(i)<='F'
                        || token.charAt(i)>='0' && token.charAt(i)<='9')
                    continue;
                else
                    return false;
            }
        }
        return true;
    }

    private boolean isValidIPv4(String ip) {
        int cntDots = 0;
        for (int i = 0; i < ip.length(); i++) {
            if(ip.charAt(i) == '.')
                cntDots++;
        }
        String[] tokens = ip.split("\\.");
        if(cntDots != 3 || tokens.length != 4)
            return false;
        for(String token : tokens){
            if(token.length()>3 || token.length()<1)
                return false;
            if(token.length()>1 && token.charAt(0) == '0')
                return false;
            if(!token.matches("\\d+")){
                return false;
            }
            int num = Integer.parseInt(token);
            if(num>255 || num<0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String IP = "172.16.254.1";
        A468_ValidateIPAddress ipAddress = new A468_ValidateIPAddress();
        String res = ipAddress.validIPAddress(IP);
        System.out.println(res);
    }
}
