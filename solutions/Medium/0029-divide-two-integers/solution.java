// ──────────────────────────────────────────────────
// Problem  : 29. Divide Two Integers
// Difficulty: Medium
// Tags     : Math, Bit Manipulation
// Link     : https://leetcode.com/problems/divide-two-integers/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42308000 (beats 0%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == divisor)
            return 1;

        
        boolean isPositive = (dividend < 0) == (divisor < 0);

        
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        long ans = 0;

        
        while (a >= b) {
            int q = 0;
            
            
            while (a > (b << (q + 1)))
                q++;
            
            
            ans += (1L << q);
            a -= (b << q);
        }

        
        if (ans == (1L << 31) && isPositive)
            return Integer.MAX_VALUE;

        
        return isPositive ? (int) ans : (int) -ans;
    }
}