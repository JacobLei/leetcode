import java.util.*;

public class A721_AccountsMerge {

    // buildgraph + DFSsearch， 还可以用BFS求解还一种方法是使用并查集
    public List<List<String>> accountsMerge(List<List<String>> accounts){
        List<List<String>> ret = new LinkedList<>();
        Map<String, Set<String>> graph = new HashMap<>();   // <email node, neighbor, node>
        Map<String, String> name = new HashMap<>();         // <email, username>

        // build the graph
        for(List<String> account : accounts){
            String userName = account.get(0);
            for(int i=1; i<account.size(); ++i){
                if(!graph.containsKey(account.get(i))){
                    graph.put(account.get(i), new HashSet<>());
                }
                name.put(account.get(i), userName);

                if(i == 1) continue;
                graph.get(account.get(i)).add(account.get(i-1));        // 将相邻的email添加到同一个Set中
                graph.get(account.get(i-1)).add(account.get(i));        // 同理
            }
        }

        Set<String> visited = new HashSet<>();
        //DFS search the graph
        for(String email : name.keySet()){
            List<String> list = new LinkedList<>();
            if(visited.add(email)){
                dfs(graph, email, visited, list);
                list.add(0, name.get(email));
                ret.add(list);
            }
        }

        return ret;
    }

    private void dfs(Map<String, Set<String>> graph, String email, Set<String> visited, List<String> list) {
        list.add(email);
        for(String next : graph.get(email)){
            if(visited.add(next))
                dfs(graph, next, visited, list);
        }
    }

    public static void main(String[] args) {
        List<List<String>> accounts = new LinkedList<>();
        String[][] s = {{"John","johnsmith@mail.com", "john00@mail.com"}, {"John", "johnnybravo@mail.com"}, {"John", "johnsmith@mail.com", "john_newyork@mail.com"}, {"Mary", "mary@mail.com"}};
        for(int i=0; i<s.length; ++i){
            List<String> account = new LinkedList<>();
            for(int j=0; j<s[i].length; ++j){
                account.add(s[i][j]);
            }
            accounts.add(account);
        }

        A721_AccountsMerge accountsMerge = new A721_AccountsMerge();

        List<List<String>> ret = accountsMerge.accountsMerge(accounts);

        for(List<String> account : ret){
            for(String str : account){
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}
