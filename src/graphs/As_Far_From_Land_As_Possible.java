package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class As_Far_From_Land_As_Possible {

    class Pair {
        int row;
        int col;
        int distance;

        Pair(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    private static final int[] xDir = { 0, 0, 1, -1 };
    private static final int[] yDir = { -1, 1, 0, 0 };

    public int maxDistance(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<Pair> queue = initializeQueue(grid, visited);

        if (queue.isEmpty() || queue.size() == n * n) {
            return -1;
        }

        return bfs(queue, visited, grid, n);
    }

    private Queue<Pair> initializeQueue(int[][] grid, boolean[][] visited) {
        Queue<Pair> queue = new LinkedList<>();
        int n = grid.length;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    queue.add(new Pair(row, col, 0));
                    visited[row][col] = true;
                }
            }
        }

        return queue;
    }

    private int bfs(Queue<Pair> queue, boolean[][] visited, int[][] grid, int n) {
        int maxDistance = 0;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int row = current.row;
            int col = current.col;
            int distance = current.distance;

            for (int direction = 0; direction < 4; direction++) {
                int newRow = row + xDir[direction];
                int newCol = col + yDir[direction];

                if (isValid(newRow, newCol, n, visited, grid)) {
                    visited[newRow][newCol] = true;
                    queue.add(new Pair(newRow, newCol, distance + 1));
                    maxDistance = distance + 1;
                }
            }
        }

        return maxDistance;
    }

    private boolean isValid(int row, int col, int n, boolean[][] visited, int[][] grid) {
        return row >= 0 && row < n && col >= 0 && col < n && !visited[row][col] && grid[row][col] == 0;
    }
}
