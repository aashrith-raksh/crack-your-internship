package graphs;

import java.util.ArrayList;
import java.util.Stack;

class StronglyConnectedComponents {
    // Helper function to perform topological sorting
    private void performTopoSort(int node, ArrayList<ArrayList<Integer>> graph, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (Integer neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                performTopoSort(neighbor, graph, visited, stack);
            }
        }
        stack.push(node);
    }

    // Helper function to perform DFS
    private void performDFS(int node, ArrayList<ArrayList<Integer>> reversedGraph, boolean[] visited) {
        visited[node] = true;
        for (Integer neighbor : reversedGraph.get(node)) {
            if (!visited[neighbor]) {
                performDFS(neighbor, reversedGraph, visited);
            }
        }
    }

    public int kosaraju(int vertices, ArrayList<ArrayList<Integer>> graph) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices];

        // Step 1: Perform topological sort on the original graph
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                performTopoSort(i, graph, visited, stack);
            }
        }

        // Step 2: Create the reversed graph
        ArrayList<ArrayList<Integer>> reversedGraph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            reversedGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < vertices; i++) {
            for (Integer neighbor : graph.get(i)) {
                reversedGraph.get(neighbor).add(i);
            }
        }

        // Step 3: Perform DFS on the reversed graph in the order of decreasing finish time
        visited = new boolean[vertices];
        int stronglyConnectedComponentsCount = 0;
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited[current]) {
                performDFS(current, reversedGraph, visited);
                stronglyConnectedComponentsCount++;
            }
        }

        return stronglyConnectedComponentsCount;
    }
}
