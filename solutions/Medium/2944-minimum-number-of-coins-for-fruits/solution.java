// ──────────────────────────────────────────────────
// Problem  : 2944. Minimum Number of Coins for Fruits
// Difficulty: Medium
// Tags     : Array, Dynamic Programming, Queue, Heap (Priority Queue), Monotonic Queue
// Link     : https://leetcode.com/problems/minimum-number-of-coins-for-fruits/
// Runtime  : 4 ms (beats 77%)
// Memory   : 44932000 (beats 89%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minimumCoins(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n + 2];

        for (int i = n; i >= 1; i--) {
            int maxReach = Math.min(n, 2 * i);
            int minNext = Integer.MAX_VALUE;
            for (int j = i + 1; j <= maxReach + 1; j++) {
                minNext = Math.min(minNext, dp[j]);
            }
            dp[i] = prices[i - 1] + (minNext == Integer.MAX_VALUE ? 0 : minNext);
        }

        return dp[1];
    }
}