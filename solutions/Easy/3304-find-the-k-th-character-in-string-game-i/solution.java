// ──────────────────────────────────────────────────
// Problem  : 3304. Find the K-th Character in String Game I
// Difficulty: Easy
// Tags     : Math, Bit Manipulation, Recursion, Simulation
// Link     : https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/
// Runtime  : 0 ms (beats 100%)
// Memory   : 43108000 (beats 70%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public char kthCharacter(int k) {
        return (char) ('a' + Integer.bitCount(k - 1) % 26);
    }
}