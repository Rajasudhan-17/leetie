// ──────────────────────────────────────────────────
// Problem  : 397. Integer Replacement
// Difficulty: Medium
// Tags     : Dynamic Programming, Greedy, Bit Manipulation, Memoization
// Link     : https://leetcode.com/problems/integer-replacement/
// Runtime  : 0 ms (beats 100%)
// Memory   : 41396000 (beats 98%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int integerReplacement(int n) {
        long N = n;
        int count = 0;
        while (N > 1) {
            if (N % 2 == 0) {
                N /= 2;
            } else if (N % 4 == 1 || N == 3) {
                N--;
            } else {
                N++;
            }
            count++;
        }
        return count;
    }
}