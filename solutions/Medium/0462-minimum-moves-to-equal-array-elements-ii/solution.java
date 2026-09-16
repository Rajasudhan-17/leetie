// ──────────────────────────────────────────────────
// Problem  : 462. Minimum Moves to Equal Array Elements II
// Difficulty: Medium
// Tags     : Array, Math, Sorting
// Link     : https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
// Runtime  : 9 ms (beats 97%)
// Memory   : 46960000 (beats 85%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int moves = 0;
        
        while (left < right) {
            moves += nums[right] - nums[left];
            left++;
            right--;
        }
        
        return moves;
    }
}