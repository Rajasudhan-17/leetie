// ──────────────────────────────────────────────────
// Problem  : 168. Excel Sheet Column Title
// Difficulty: Easy
// Tags     : Math, String
// Link     : https://leetcode.com/problems/excel-sheet-column-title/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42528000 (beats 41%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;
            res.insert(0, (char) ((columnNumber % 26) + 'A'));
            columnNumber /= 26;
        }
        
        return res.toString();        
    }
}