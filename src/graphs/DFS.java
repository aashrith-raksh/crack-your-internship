
// 2. DFS of graph

package graphs;

import java.util.ArrayList;

public class DFS {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here

        ArrayList<Integer> result = new ArrayList<>();
        dfs(0, new boolean[V], adj, result);
        return result;

    }

    void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adjList, ArrayList<Integer> result) {
        visited[node] = true;
        result.add(node);

        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adjList, result);
            }
        }
    }

}
