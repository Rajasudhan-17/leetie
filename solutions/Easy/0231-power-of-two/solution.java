// ──────────────────────────────────────────────────
// Problem  : 231. Power of Two
// Difficulty: Easy
// Tags     : Math, Bit Manipulation, Recursion
// Link     : https://leetcode.com/problems/power-of-two/
// Runtime  : 1 ms (beats 97%)
// Memory   : 42788000 (beats 18%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n - 1) == 0;
    }
}