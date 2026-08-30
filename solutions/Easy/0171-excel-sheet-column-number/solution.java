// ──────────────────────────────────────────────────
// Problem  : 171. Excel Sheet Column Number
// Difficulty: Easy
// Tags     : Math, String
// Link     : https://leetcode.com/problems/excel-sheet-column-number/
// Runtime  : 1 ms (beats 91%)
// Memory   : 43580000 (beats 55%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int titleToNumber(String columnTitle) {
        long ans = 0;

        // Same idea as decimal parsing, but base is 26.
        for (int i = 0; i < columnTitle.length(); i++) {
            char ch = columnTitle.charAt(i);
            ans = ans * 26 + (ch - 'A' + 1);
        }

        return (int) ans;
    }
}