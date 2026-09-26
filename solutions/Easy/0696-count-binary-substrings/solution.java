// ──────────────────────────────────────────────────
// Problem  : 696. Count Binary Substrings
// Difficulty: Easy
// Tags     : Two Pointers, String
// Link     : https://leetcode.com/problems/count-binary-substrings/
// Runtime  : 11 ms (beats 54%)
// Memory   : 46328000 (beats 51%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int countBinarySubstrings(String s) {
        int ans = 0;
        int prev = 0;
        int cur = 1;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                ans += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            } else {
                cur++;
            }
        }
        
        return ans + Math.min(prev, cur);
    }
}