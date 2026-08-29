// ──────────────────────────────────────────────────
// Problem  : 1480. Running Sum of 1d Array
// Difficulty: Easy
// Tags     : Array, Prefix Sum
// Link     : https://leetcode.com/problems/running-sum-of-1d-array/
// Runtime  : 0 ms (beats 100%)
// Memory   : 43776000 (beats 98%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] runningSum(int[] nums) {
        for(int i=1;i<nums.length;i++){
            nums[i]+=nums[i-1];
        }
        return nums;
    }
}