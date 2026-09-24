// ──────────────────────────────────────────────────
// Problem  : 326. Power of Three
// Difficulty: Easy
// Tags     : Math, Recursion
// Link     : https://leetcode.com/problems/power-of-three/
// Runtime  : 8 ms (beats 92%)
// Memory   : 46048000 (beats 45%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        return n % 3 == 0 && isPowerOfThree(n / 3);
    }
}