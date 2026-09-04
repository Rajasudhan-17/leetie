// ──────────────────────────────────────────────────
// Problem  : 1423. Maximum Points You Can Obtain from Cards
// Difficulty: Medium
// Tags     : Array, Sliding Window, Prefix Sum
// Link     : https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
// Runtime  : 2 ms (beats 100%)
// Memory   : 61400000 (beats 94%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int maxScore(int[] C, int K) {
        int total = 0;
        for (int i = 0; i < K; i++) total += C[i];
        int best = total;
        for (int i = K - 1, j = C.length - 1; i >= 0; i--, j--) {
            total += C[j] - C[i];
            best = Math.max(best, total);
        }
        return best;
    }
}