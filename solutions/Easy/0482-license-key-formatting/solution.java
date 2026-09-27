// ──────────────────────────────────────────────────
// Problem  : 482. License Key Formatting
// Difficulty: Easy
// Tags     : String
// Link     : https://leetcode.com/problems/license-key-formatting/
// Runtime  : 10 ms (beats 89%)
// Memory   : 46400000 (beats 60%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != '-') {
                if (count == k) {
                    sb.append('-');
                    count = 0;
                }
                sb.append(Character.toUpperCase(c));
                count++;
            }
        }
        
        return sb.reverse().toString();
    }
}