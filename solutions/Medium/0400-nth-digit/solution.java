// ──────────────────────────────────────────────────
// Problem  : 400. Nth Digit
// Difficulty: Medium
// Tags     : Math, Binary Search
// Link     : https://leetcode.com/problems/nth-digit/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42076000 (beats 59%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findNthDigit(int n) {
        long len = 1;
        long count = 9;
        long start = 1;

        while (n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }

        start += (n - 1) / len;
        String s = Long.toString(start);
        return Character.getNumericValue(s.charAt((int)((n - 1) % len)));
    }
}