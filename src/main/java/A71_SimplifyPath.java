public class A71_SimplifyPath {
    public String simplifyPath(String path){
        String ret = "";
        if(path.isEmpty()){
            return ret;
        }
        int ignorane = 0;
        String[] items = path.split("/");
        for(int i=items.length-1; i>=0; --i){
            if(items[i].equals("") || items[i].equals(".")){
                continue;
            }else if(items[i].equals("..")){
                ignorane++;
            }else if(ignorane > 0){
                ignorane--;
            }else {
                ret = "/" + items[i] + ret;
            }
        }
        return ret.isEmpty() ? "/" : ret;
    }
}
