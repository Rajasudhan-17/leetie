// ──────────────────────────────────────────────────
// Problem  : 2327. Number of People Aware of a Secret
// Difficulty: Medium
// Tags     : Dynamic Programming, Queue, Simulation
// Link     : https://leetcode.com/problems/number-of-people-aware-of-a-secret/
// Runtime  : 3 ms (beats 97%)
// Memory   : 41872000 (beats 85%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long mod = 1_000_000_007L;
        long[] dp = new long[n + 1];
        dp[1] = 1;
        long sharing = 0;

        for (int i = 2; i <= n; i++) {
            if (i - delay >= 1) {
                sharing = (sharing + dp[i - delay]) % mod;
            }
            if (i - forget >= 1) {
                sharing = (sharing - dp[i - forget] + mod) % mod;
            }
            dp[i] = sharing;
        }

        long ans = 0;
        for (int i = n - forget + 1; i <= n; i++) {
            if (i >= 1) {
                ans = (ans + dp[i]) % mod;
            }
        }

        return (int) ans;
    }
}