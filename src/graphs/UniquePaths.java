pubic class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        /*--------- MEMOIZATION -----------
         * int ans = computePaths(0, 0, dp, m, n);
         * return ans;
         */

        /*----------- TABULATION ------------
         dp[m-1][n-1] = 1;
        
         for(int i=m-1; i>=0; i--){
                for(int j=n-1; j>=0; j--){
                    if(i == m-1 && j == n-1) continue;
                    int downSum = 0;
                    int rightSum = 0;
                    if(i + 1 <= m-1){
                        downSum = dp[i+1][j];
                    }
            
                    if(j + 1 <= n-1){
                        rightSum = dp[i][j+1];
                    }
            
                    // System.out.println("At [" + i + "][" + j+ "]");
                    // System.out.println("storing " + (rightSum + downSum) + "\n");
                    dp[i][j] = downSum + rightSum;
                }
            }
        
        
         return dp[0][0];
        
        
        */

       
    }

    public int computePaths(int row, int col, int[][] dp, int m, int n) {

        if (row < 0 || row >= m) {
            return 0;
        }

        if (col < 0 || col >= n) {
            return 0;
        }

        if (row == m - 1 && col == n - 1) {
            return 1;
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int downWays = computePaths(row + 1, col, dp, m, n);
        int rightWays = computePaths(row, col + 1, dp, m, n);

        return dp[row][col] = downWays + rightWays;
    }

}
