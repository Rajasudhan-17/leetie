// ──────────────────────────────────────────────────
// Problem  : 394. Decode String
// Difficulty: Medium
// Tags     : String, Stack, Recursion
// Link     : https://leetcode.com/problems/decode-string/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42068000 (beats 97%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    private int index = 0;

    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        int k = 0;

        while (index < s.length()) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
                index++;
            } else if (c == '[') {
                index++;
                String decodedSubstring = decodeString(s);
                while (k > 0) {
                    result.append(decodedSubstring);
                    k--;
                }
            } else if (c == ']') {
                index++;
                return result.toString();
            } else {
                result.append(c);
                index++;
            }
        }

        return result.toString();
    }
}