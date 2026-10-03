// ──────────────────────────────────────────────────
// Problem  : 633. Sum of Square Numbers
// Difficulty: Medium
// Tags     : Math, Two Pointers, Binary Search
// Link     : https://leetcode.com/problems/sum-of-square-numbers/
// Runtime  : 3 ms (beats 97%)
// Memory   : 42072000 (beats 68%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean judgeSquareSum(int c) {
        long left = 0;
        long right = (long) Math.sqrt(c);
        
        while (left <= right) {
            long sum = left * left + right * right;
            
            if (sum == c) {
                return true;
            } else if (sum < c) {
                left++;
            } else {
                right--;
            }
        }
        
        return false;
    }
}