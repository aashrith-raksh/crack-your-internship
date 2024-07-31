package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class InformAllEmployees {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        // array to store each manager's subordinates
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] parentChilds = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            parentChilds[i] = new ArrayList<>();
        }

        // store parentChilds array with the employee-manager relationships
        for (int i = 0; i < n; i++) {
            if (i == headID) continue;
            int parent = manager[i];
            parentChilds[parent].add(i);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { headID, informTime[headID] });

        int maxInformTime = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currManager = curr[0];
            int currTime = curr[1];

            // Update the maximum inform time
            maxInformTime = Math.max(maxInformTime, currTime);

            for (int child : parentChilds[currManager]) {
                queue.offer(new int[] { child, currTime + informTime[child] });
            }
        }

        return maxInformTime;
    }
}
