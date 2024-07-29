package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rat_In_A_Maze_Problem {
    private void get(int[][] mat, int n, int i, int j, boolean[][] visited, List<String> res, String s) {
        if (i == n - 1 && j == n - 1 && mat[i][j] != 0) {
            res.add(s);
            return;
        }
        if (i < 0 || j < 0 || i >= n || j >= n || visited[i][j] || mat[i][j] == 0) {
            return;
        }

        visited[i][j] = true;

        get(mat, n, i, j + 1, visited, res, s + "R");
        get(mat, n, i, j - 1, visited, res, s + "L");
        get(mat, n, i + 1, j, visited, res, s + "D");
        get(mat, n, i - 1, j, visited, res, s + "U");

        visited[i][j] = false;
    }

    public ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> res = new ArrayList<>();
        int n = mat.length;
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }

        get(mat, n, 0, 0, visited, res, "");
        return res;
    }
}

