package dynamic_programming;

import java.util.Arrays;
import java.util.HashMap;

public class OnesAndZeroes {

    class Pair {
        int zero;
        int ones;

        Pair(int zero, int ones) {
            this.zero = zero;
            this.ones = ones;
        }
    }

    public int findMaxForm(String[] strs, int m, int n) {
        HashMap<String, Pair> map = new HashMap<>();
        updateMap(strs, map);
        int size = strs.length;
        int[][][] dp = new int[size][m + 1][n + 1];
        for (int[][] matrix : dp) {
            for (int[] rows : matrix) {
                Arrays.fill(rows, -1);
            }
        }
        return findMaxFormUtil(strs, 0, m, n, map, size, dp);
    }

    private void updateMap(String[] strs, HashMap<String, Pair> map) {
        for (String s : strs) {
            int zero = 0;
            int one = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0')
                    zero++;
                else
                    one++;
            }
            map.put(s, new Pair(zero, one));
        }
    }

    private int findMaxFormUtil(String[] strs, int ind, int zeroes, int ones, HashMap<String, Pair> map, int size,
            int[][][] dp) {
        // Base cases
        if ((zeroes == 0 && ones == 0) || ind == size)
            return 0;
        if (dp[ind][zeroes][ones] != -1)
            return dp[ind][zeroes][ones];

        int currZeroes = map.get(strs[ind]).zero;
        int currOnes = map.get(strs[ind]).ones;
        int take = Integer.MIN_VALUE;

        // Recursive case: consider taking the current string
        if (currZeroes <= zeroes && currOnes <= ones) {
            take = 1 + findMaxFormUtil(strs, ind + 1, zeroes - currZeroes, ones - currOnes, map, size, dp);
        }

        // Recursive case: consider not taking the current string
        int notTake = findMaxFormUtil(strs, ind + 1, zeroes, ones, map, size, dp);

        // Store and return the maximum of both choices
        return dp[ind][zeroes][ones] = Math.max(take, notTake);
    }

}
