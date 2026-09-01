// ──────────────────────────────────────────────────
// Problem  : 338. Counting Bits
// Difficulty: Easy
// Tags     : Dynamic Programming, Bit Manipulation
// Link     : https://leetcode.com/problems/counting-bits/
// Runtime  : 2 ms (beats 96%)
// Memory   : 48104000 (beats 98%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        int sub = 1;

        for (int i = 1; i <= n; i++) {
            if (sub * 2 == i) {
                sub = i;
            }

            dp[i] = dp[i - sub] + 1;
        }

        return dp;        
    }
}