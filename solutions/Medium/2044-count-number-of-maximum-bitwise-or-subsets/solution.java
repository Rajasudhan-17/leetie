// ──────────────────────────────────────────────────
// Problem  : 2044. Count Number of Maximum Bitwise-OR Subsets
// Difficulty: Medium
// Tags     : Array, Backtracking, Bit Manipulation, Enumeration
// Link     : https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/
// Runtime  : 2 ms (beats 100%)
// Memory   : 42852000 (beats 61%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int countMaxOrSubsets(int[] nums) {
           int maxOR = 0;
        for (int num : nums) {
            maxOR |= num;
        }
        
        return backtrack(nums, maxOR, 0, 0);
    }

    private int backtrack(int[] nums, int maxOR, int index, int currentOR) {
        if (index == nums.length) {
            return currentOR == maxOR ? 1 : 0;
        }
        
        if (currentOR == maxOR) {
            return 1 << (nums.length - index);
        }
        
        return backtrack(nums, maxOR, index + 1, currentOR | nums[index]) +
               backtrack(nums, maxOR, index + 1, currentOR);
    }
}