// ──────────────────────────────────────────────────
// Problem  : 1695. Maximum Erasure Value
// Difficulty: Medium
// Tags     : Array, Hash Table, Sliding Window
// Link     : https://leetcode.com/problems/maximum-erasure-value/
// Runtime  : 5 ms (beats 100%)
// Memory   : 84796000 (beats 95%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int maxScore = 0;
        int currentScore = 0;
        boolean[] seen = new boolean[10001];
        int left = 0;
        
        for (int right = 0; right < nums.length; right++) {
            while (seen[nums[right]]) {
                seen[nums[left]] = false;
                currentScore -= nums[left];
                left++;
            }
            
            seen[nums[right]] = true;
            currentScore += nums[right];
            maxScore = Math.max(maxScore, currentScore);
        }
        
        return maxScore;
    }
}