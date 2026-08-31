// ──────────────────────────────────────────────────
// Problem  : 434. Number of Segments in a String
// Difficulty: Easy
// Tags     : String
// Link     : https://leetcode.com/problems/number-of-segments-in-a-string/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42964000 (beats 15%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int countSegments(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                count++;
            }
        }
        return count;
    }
}