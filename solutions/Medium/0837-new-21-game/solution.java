// ──────────────────────────────────────────────────
// Problem  : 837. New 21 Game
// Difficulty: Medium
// Tags     : Math, Dynamic Programming, Sliding Window, Probability and Statistics
// Link     : https://leetcode.com/problems/new-21-game/
// Runtime  : 4 ms (beats 60%)
// Memory   : 46680000 (beats 40%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0 || n >= k + maxPts) {
            return 1.0;
        }
        
        double[] dp = new double[n + 1];
        dp[0] = 1.0;
        double windowSum = 1.0;
        double ans = 0.0;
        
        for (int i = 1; i <= n; i++) {
            dp[i] = windowSum / maxPts;
            
            if (i < k) {
                windowSum += dp[i];
            } else {
                ans += dp[i];
            }
            
            if (i - maxPts >= 0) {
                windowSum -= dp[i - maxPts];
            }
        }
        
        return ans;
    }
}