package dynamic_programming;

public class MaximizeTheCutSegments {

    int ans = 0;

    public int findLength(int[] nums1, int[] nums2) {
        Integer[][] dp = new Integer[nums1.length][nums2.length];
        helper(nums1, nums2, 0, 0, dp);
        return ans;
    }

    public int helper(int[] nums1, int[] nums2, int i, int j, Integer[][] dp) {
        if (i == nums1.length || j == nums2.length) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int take = 0;
        // We are increasing value of take if value of both the array are equal
        if (nums1[i] == nums2[j]) {
            take = 1 + helper(nums1, nums2, i + 1, j + 1, dp);
            // Here, We put maxiumum value of take in our ans
            ans = Math.max(ans, take);
        }
        // Subarray are successive, so if values are not equal then we doesn't need to
        // count that part
        helper(nums1, nums2, i + 1, j, dp);
        helper(nums1, nums2, i, j + 1, dp);
        // lastly we return the value of take
        return dp[i][j] = take;
    }
}
