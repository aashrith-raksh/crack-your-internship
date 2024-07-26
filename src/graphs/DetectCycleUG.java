
// 2. DFS of graph

package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DetectCycleUG {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here

        Set<Integer> visited = new HashSet<>();
        for (int node = 0; node < V; node++) {
            if (!visited.contains(node)) {
                if (isCycleUtil(node, -1, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCycleUtil(int node, int parent, Set<Integer> visited, ArrayList<ArrayList<Integer>> adj) {
        visited.add(node);
        for (int neighbor : adj.get(node)) {
            if (!visited.contains(neighbor)) {
                if (isCycleUtil(neighbor, node, visited, adj)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

}
