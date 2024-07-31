package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {
    class Node {
        String dest;
        double val;

        Node(String d, double v) {
            dest = d;
            val = v;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Node>> graph = buildGraph(equations, values);
        double[] results = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            results[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), graph);
        }

        return results;
    }

    private double dfs(String src, String dest, Set<String> visited, Map<String, List<Node>> graph) {
        if (!graph.containsKey(src) || !graph.containsKey(dest)) return -1.0;
        if (src.equals(dest)) return 1.0;
        
        visited.add(src);

        for (Node neighbor : graph.get(src)) {
            if (!visited.contains(neighbor.dest)) {
                double result = dfs(neighbor.dest, dest, visited, graph);
                if (result != -1.0) return result * neighbor.val;
            }
        }

        return -1.0;
    }

    private Map<String, List<Node>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, List<Node>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String src = equations.get(i).get(0);
            String dest = equations.get(i).get(1);
            graph.putIfAbsent(src, new ArrayList<>());
            graph.putIfAbsent(dest, new ArrayList<>());
            graph.get(src).add(new Node(dest, values[i]));
            graph.get(dest).add(new Node(src, 1 / values[i]));
        }

        return graph;
    }

}
