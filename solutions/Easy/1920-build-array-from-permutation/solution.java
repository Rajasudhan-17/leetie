// ──────────────────────────────────────────────────
// Problem  : 1920. Build Array from Permutation
// Difficulty: Easy
// Tags     : Array, Simulation
// Link     : https://leetcode.com/problems/build-array-from-permutation/
// Runtime  : 1 ms (beats 100%)
// Memory   : 47048000 (beats 73%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] buildArray(int[] nums) {
        int[] res=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            res[i]=nums[nums[i]];
        }
        return res;
    }
}