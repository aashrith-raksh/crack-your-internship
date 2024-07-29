package graphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {
    class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

    }

    // boolean[][] visited;

    int[] x = new int[4];
    int[] y = new int[4];

    public int numIslands(char[][] grid) {
        createDirections(x, y);

        int m = grid.length;
        boolean[][] visited = new boolean[m][];

        for (int i = 0; i < m; i++) {
            int n = grid[i].length;
            visited[i] = new boolean[n];
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }

        int numberOfIslands = 0;

        for (int i = 0; i < m; i++) {
            int n = grid[i].length;
            for (int j = 0; j < n; j++) {

                if (!visited[i][j] && grid[i][j] == '1') {
                    numberOfIslands++;
                    findIslandsUtil(new Pair(i, j), m, n, visited, grid);

                }
            }
        }

        return numberOfIslands;

    }

    void findIslandsUtil(Pair start, int m, int n, boolean[][] visited, char[][] grid) {

        Queue<Pair> queue = new ArrayDeque<>();
        visited[start.row][start.col] = true;
        queue.add(start);

        while (queue.size() != 0) {
            Pair curVertex = queue.remove();
            int curRow = curVertex.row;
            int curCol = curVertex.col;

            for (int i = 0; i < 4; i++) {
                int nextRow = curRow + x[i];
                int nextCol = curCol + y[i];

                if ((nextRow < m && nextRow >= 0) && (nextCol < n && nextCol >= 0)) {

                    if (!visited[nextRow][nextCol] && grid[nextRow][nextCol] == '1') {
                        visited[nextRow][nextCol] = true;
                        queue.add(new Pair(nextRow, nextCol));
                    }
                }
            }
        }
    }

    void createDirections(int[] x, int[] y) {
        y[0] = 1;
        x[1] = 1;
        y[2] = -1;
        x[3] = -1;

    }

}
