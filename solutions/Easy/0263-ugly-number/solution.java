// ──────────────────────────────────────────────────
// Problem  : 263. Ugly Number
// Difficulty: Easy
// Tags     : Math
// Link     : https://leetcode.com/problems/ugly-number/
// Runtime  : 1 ms (beats 99%)
// Memory   : 42496000 (beats 69%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        
        return n == 1;
    }
}