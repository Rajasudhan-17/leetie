// ──────────────────────────────────────────────────
// Problem  : 390. Elimination Game
// Difficulty: Medium
// Tags     : Math, Recursion
// Link     : https://leetcode.com/problems/elimination-game/
// Runtime  : 4 ms (beats 35%)
// Memory   : 42776000 (beats 93%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int lastRemaining(int n) {
        int head = 1;
        int step = 1;
        boolean leftToRight = true;
        int remaining = n;
        
        while (remaining > 1) {
            if (leftToRight || remaining % 2 == 1) {
                head += step;
            }
            step *= 2;
            remaining /= 2;
            leftToRight = !leftToRight;
        }
        
        return head;
    }
}