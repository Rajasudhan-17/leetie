// ──────────────────────────────────────────────────
// Problem  : 172. Factorial Trailing Zeroes
// Difficulty: Medium
// Tags     : Math
// Link     : https://leetcode.com/problems/factorial-trailing-zeroes/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42400000 (beats 55%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int trailingZeroes(int n) {
        int ans = Math.floorDiv(n, 5);
        ans += Math.floorDiv(n, 25);
        ans += Math.floorDiv(n, 125);
        ans += Math.floorDiv(n, 625);
        ans += Math.floorDiv(n, 3125);
        
        
        return ans;
    }
}