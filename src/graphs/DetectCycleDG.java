
// 4. Detect cycle in directed graph

package graphs;

import java.util.ArrayList;

public class DetectCycleDG {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(vis, new boolean[V], i, adj)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(boolean[] vis, boolean[] inSamePath, int source, ArrayList<ArrayList<Integer>> adj) {
        // boolean inSamePath[] = new boolean[V];

        if (vis[source]) {
            if (inSamePath[source]) {
                return true;
            }

            return false;
        }

        if (!vis[source]) {

            vis[source] = true;
            inSamePath[source] = true;
        }

        for (int i = 0; i < adj.get(source).size(); i++) {
            int nextSource = adj.get(source).get(i);
            boolean temp = dfs(vis, inSamePath, nextSource, adj);
            if (temp)
                return true;

        }

        inSamePath[source] = false;
        return false;

    }

}
