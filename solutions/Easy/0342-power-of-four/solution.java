// ──────────────────────────────────────────────────
// Problem  : 342. Power of Four
// Difficulty: Easy
// Tags     : Math, Bit Manipulation, Recursion
// Link     : https://leetcode.com/problems/power-of-four/
// Runtime  : 1 ms (beats 90%)
// Memory   : 42656000 (beats 33%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        return Math.log(n) / Math.log(4) % 1 == 0;        
    }
}