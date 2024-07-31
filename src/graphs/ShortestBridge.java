package graphs;

import java.util.*;

public class ShortestBridge {

    private static final int[][] DIRS = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    Set<List<Integer>> island = findIsland(grid, i, j, n, new HashSet<>());
                    return findBridge(grid, n, island);
                }
            }
        }
        return 0;
    }

    private Set<List<Integer>> findIsland(int[][] grid, int r, int c, int n, Set<List<Integer>> island) {
        if (!isOutOfBounds(n, r, c) && grid[r][c] == 1 && island.add(List.of(r, c))) {
            for (int[] dir : DIRS) {
                findIsland(grid, r + dir[0], c + dir[1], n, island);
            }
        }
        return island;
    }

    private boolean isOutOfBounds(int n, int r, int c) {
        return r < 0 || r >= n || c < 0 || c >= n;
    }

    private int findBridge(int[][] grid, int n, Set<List<Integer>> island) {
        Queue<List<Integer>> queue = new ArrayDeque<>(island);
        int bridge = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                List<Integer> cell = queue.poll();
                for (int[] dir : DIRS) {
                    int r = cell.get(0) + dir[0];
                    int c = cell.get(1) + dir[1];
                    List<Integer> next = List.of(r, c);
                    if (isOutOfBounds(n, r, c) || !island.add(next)) continue;
                    if (grid[r][c] == 1) return bridge;
                    queue.offer(next);
                }
            }
            bridge++;
        }
        return bridge;
    }
}
