package graphs;
import java.util.*;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++){
            dp[i] = new int[n];
            Arrays.fill(dp[i], -1);
        }

        int ans = minPathSumUtil(m-1, n-1, grid, dp, m, n);

        return ans;
        
    }

    public int minPathSumUtil(int row, int col, int[][] grid, int[][] dp, int m, int n){
        // BASE CASES
        if(row == 0 && col == 0){
            return grid[0][0];
        }

         if (row < 0 || row >= m) {
            return -1;
        }

        if (col < 0 || col >= n) {
            return -1;
        }

        if(dp[row][col] != -1) return dp[row][col];

        int leftVal = minPathSumUtil(row, col-1, grid, dp, m, n);
        int upVal = minPathSumUtil(row-1, col, grid, dp, m, n);

        int minVal;

        if(leftVal == -1 || upVal == -1){
            minVal = Math.max(leftVal, upVal);
        }else{
            minVal = Math.min(leftVal, upVal);
        }

        int curVal = minVal + grid[row][col];
        dp[row][col] = curVal;
        return curVal;
    }

    @Override
    public String toString() {
        return "MinPathSum []";
    }
}
