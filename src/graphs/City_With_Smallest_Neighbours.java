package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class City_With_Smallest_Neighbours {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(new int[] { edge[1], edge[2] });
            adjList.get(edge[1]).add(new int[] { edge[0], edge[2] });
        }


        for (int i = 0; i < n; i++) {
            // rc --> reachable cities list
            List<Integer> rc = new ArrayList<>();
            findReachableCities(i, rc, distanceThreshold, n, adjList);
            map.put(i, rc);
        }


        int ans = Integer.MAX_VALUE;
        int size = Integer.MAX_VALUE;

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int key = entry.getKey();
            int valueSize = entry.getValue().size();

            if (valueSize < size) {
                ans = key;
                size = valueSize;
            }

            else if (valueSize == size) {
                if (key > ans) {
                    ans = key;
                }
            }
        }

        return ans;

    }

    public void printAdjList(List<List<int[]>> adjList) {
        // TODO Auto-generated method stub
        System.out.println("-------------- adjList --------------------");

        for (int i = 0; i < adjList.size(); i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                int[] edge = adjList.get(i).get(j);
                int nei = edge[0];
                int cost = edge[1];
                System.out.print(" " + "[" + nei + "][" + cost + "]");

            }

            System.out.println();

        }

        System.out.println("----------------------------------------------\n");

    }

    public void findReachableCities(int source, List<Integer> list, int td, int V, List<List<int[]>> adj) {
        int[] dis = new int[V];
        Arrays.fill(dis, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (x, y) -> {
                    return Integer.compare(x[0], y[0]);
                });

        pq.add(new int[] { 0, source });
        dis[source] = 0;

        while (!pq.isEmpty()) {
            int[] group = pq.poll();
            int dist = group[0];
            int node = group[1];

            for (int i = 0; i < adj.get(node).size(); i++) {
                int[] neiGroup = adj.get(node).get(i);
                int nei = neiGroup[0];
                int newDis = neiGroup[1] + dist;

                if (newDis < dis[nei]) {
                    dis[nei] = newDis;
                    pq.add(new int[] { newDis, nei });
                }
            }
        }

        // System.out.println("dis array for " + source + ":");
        // System.out.println(Arrays.toString(dis) + "\n");

        for (int i = 0; i < dis.length; i++) {
            if (i != source && dis[i] <= td) {
                list.add(i);
            }
        }
    }

}
