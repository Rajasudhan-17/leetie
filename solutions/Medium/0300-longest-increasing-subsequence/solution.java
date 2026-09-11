// ──────────────────────────────────────────────────
// Problem  : 300. Longest Increasing Subsequence
// Difficulty: Medium
// Tags     : Array, Binary Search, Dynamic Programming, Longest Increasing Subsequence
// Link     : https://leetcode.com/problems/longest-increasing-subsequence/
// Runtime  : 2 ms (beats 100%)
// Memory   : 46316000 (beats 35%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            
            if (i < 0) {
                i = -(i + 1);
            }
            
            dp[i] = num;
            
            if (i == len) {
                len++;
            }
        }
        
        return len;
    }
}