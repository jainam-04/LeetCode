import java.util.ArrayList;
import java.util.List;

public class MaxNoOfKDivComponents {
    public static long count = 0;

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 3},
                {1, 4},
                {2, 5},
                {2, 6}
        };
        int[] values = {3, 0, 6, 1, 5, 2, 1};
        int k = 3;
        int result = maxKDivisibleComponents(n, edges, values, k);
        System.out.println(result);
    }

    public static int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        long[] subtree = new long[n];
        for(int i = 0; i < n; i++){
            subtree[i] = values[i];
        }
        getSubtree(0, adj, -1, subtree);
        dfs(0, adj, -1, subtree, k);
        return (int) (count + 1);
    }

    public static void getSubtree(int node, List<List<Integer>> adj, int parent, long[] subtree){
        if(adj.get(node).size() == 1 && adj.get(node).getFirst() == parent){
            return;
        }
        for(int neighbour : adj.get(node)){
            if(neighbour != parent){
                getSubtree(neighbour, adj, node, subtree);
                subtree[node] += subtree[neighbour];
            }
        }
    }

    public static void dfs(int node, List<List<Integer>> adj, int parent, long[] subtree, int k){
        if(adj.get(node).size() == 1 && adj.get(node).getFirst() == parent){
            return;
        }
        for(int neighbour : adj.get(node)){
            if(neighbour != parent){
                long parseSubtree = subtree[node] - subtree[neighbour];
                long childSubtree = subtree[neighbour];
                if(parseSubtree % k == 0 && childSubtree % k == 0){
                    count++;
                    subtree[node] -= subtree[neighbour];
                }
                else{
                    subtree[neighbour] = subtree[node];
                }
                dfs(neighbour, adj, node, subtree, k);
            }
        }
    }
}
