// ──────────────────────────────────────────────────
// Problem  : 647. Palindromic Substrings
// Difficulty: Medium
// Tags     : Two Pointers, String, Dynamic Programming
// Link     : https://leetcode.com/problems/palindromic-substrings/
// Runtime  : 6 ms (beats 62%)
// Memory   : 43128000 (beats 33%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            int l = i, r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                count++;
                l--;
                r++;
            }
            
            l = i;
            r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                count++;
                l--;
                r++;
            }
        }
        
        return count;
    }
}