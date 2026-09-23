// ──────────────────────────────────────────────────
// Problem  : 312. Burst Balloons
// Difficulty: Hard
// Tags     : Array, Dynamic Programming
// Link     : https://leetcode.com/problems/burst-balloons/
// Runtime  : 43 ms (beats 75%)
// Memory   : 44432000 (beats 49%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];

        for (int len = 2; len <= n + 1; len++) {
            for (int left = 0; left <= n + 1 - len; left++) {
                int right = left + len;
                for (int k = left + 1; k < right; k++) {
                    dp[left][right] = Math.max(dp[left][right], 
                        dp[left][k] + arr[left] * arr[k] * arr[right] + dp[k][right]);
                }
            }
        }
        
        return dp[0][n + 1];
    }
}