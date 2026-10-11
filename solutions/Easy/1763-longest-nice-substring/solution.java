// ──────────────────────────────────────────────────
// Problem  : 1763. Longest Nice Substring
// Difficulty: Easy
// Tags     : Hash Table, String, Divide and Conquer, Bit Manipulation, Sliding Window
// Link     : https://leetcode.com/problems/longest-nice-substring/
// Runtime  : 1 ms (beats 97%)
// Memory   : 43048000 (beats 84%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String longestNiceSubstring(String s) {
        if (s.length() < 2) return "";
        
        int lower = 0;
        int upper = 0;
        
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lower |= 1 << (c - 'a');
            } else {
                upper |= 1 << (c - 'A');
            }
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c = Character.toLowerCase(s.charAt(i));
            
            if ((lower & (1 << (c - 'a'))) > 0 && (upper & (1 << (c - 'a'))) > 0) {
                continue;
            }
            
            String left = longestNiceSubstring(s.substring(0, i));
            String right = longestNiceSubstring(s.substring(i + 1));
            
            return left.length() >= right.length() ? left : right;
        }
        
        return s;
    }
}