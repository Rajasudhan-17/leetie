// ──────────────────────────────────────────────────
// Problem  : 1137. N-th Tribonacci Number
// Difficulty: Easy
// Tags     : Math, Dynamic Programming, Memoization
// Link     : https://leetcode.com/problems/n-th-tribonacci-number/
// Runtime  : 0 ms (beats 100%)
// Memory   : 41948000 (beats 70%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        
        int t0 = 0;
        int t1 = 1;
        int t2 = 1;
        
        for (int i = 3; i <= n; i++) {
            int next = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = next;
        }
        
        return t2;
    }
}