// ──────────────────────────────────────────────────
// Problem  : 464. Can I Win
// Difficulty: Medium
// Tags     : Math, Dynamic Programming, Bit Manipulation, Memoization, Game Theory, Bitmask
// Link     : https://leetcode.com/problems/can-i-win/
// Runtime  : 62 ms (beats 96%)
// Memory   : 46080000 (beats 86%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    byte[] memo;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) return true;
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false;
        
        memo = new byte[1 << maxChoosableInteger];
        return canWin(maxChoosableInteger, desiredTotal, 0);
    }

    private boolean canWin(int max, int target, int mask) {
        if (memo[mask] != 0) return memo[mask] == 1;
        
        for (int i = 1; i <= max; i++) {
            int bit = 1 << (i - 1);
            if ((mask & bit) == 0) {
                if (target <= i || !canWin(max, target - i, mask | bit)) {
                    memo[mask] = 1;
                    return true;
                }
            }
        }
        
        memo[mask] = -1;
        return false;
    }
}