// ──────────────────────────────────────────────────
// Problem  : 376. Wiggle Subsequence
// Difficulty: Medium
// Tags     : Array, Dynamic Programming, Greedy
// Link     : https://leetcode.com/problems/wiggle-subsequence/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42656000 (beats 94%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        
        int up = 1;
        int down = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        
        return Math.max(up, down);
    }
}