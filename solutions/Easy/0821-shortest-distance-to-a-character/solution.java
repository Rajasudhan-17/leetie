// ──────────────────────────────────────────────────
// Problem  : 821. Shortest Distance to a Character
// Difficulty: Easy
// Tags     : Array, Two Pointers, String
// Link     : https://leetcode.com/problems/shortest-distance-to-a-character/
// Runtime  : 1 ms (beats 100%)
// Memory   : 43484000 (beats 97%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];
        int prev = -n; 

        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            ans[i] = i - prev;
        }

        prev = 2 * n; 
        for (int i = n - 1; i >= 0; --i) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            ans[i] = Math.min(ans[i], prev - i);
        }

        return ans;
    }
}