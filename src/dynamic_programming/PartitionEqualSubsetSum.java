package dynamic_programming;

public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {

        int sum2 = 0;
        for (int i : nums) {
            sum2 += i;
        }

        int[][][] dp = new int[nums.length][sum2+1][sum2+1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < sum2+1; j++) {
                for (int k = 0; k < sum2+1; k++) {
                    dp[i][j][k] = -1;
                }   
            }
            
        }

        return canPartitionUtil(0, 0, sum2, nums, dp);

    }

    public boolean canPartitionUtil(int ind, int sum1, int sum2, int[] nums, int[][][] dp) {

        if (ind == nums.length) {
            return false;
        }

        if (sum1 == sum2) {
            dp[ind][sum1][sum2] = 1;
            return true;
        }

        if(dp[ind][sum1][sum2] == 1) return true;

        int pickSum1 = sum1 + nums[ind];
        int pickSum2 = sum2 - nums[ind];

        boolean pick = canPartitionUtil(ind + 1, pickSum1, pickSum2, nums, dp);

        if (pick)
            return true;

        boolean leave = canPartitionUtil(ind + 1, sum1, sum2, nums, dp);


        boolean ans = pick || leave;
        dp[ind][sum1][sum2] = ans ? 1: 0;
        return ans;

    }

}
