// ──────────────────────────────────────────────────
// Problem  : 1876. Substrings of Size Three with Distinct Characters
// Difficulty: Easy
// Tags     : Hash Table, String, Sliding Window, Counting
// Link     : https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/
// Runtime  : 1 ms (beats 96%)
// Memory   : 42864000 (beats 67%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int countGoodSubstrings(String s) {
        int count = 0;
        for (int i = 0; i <= s.length() - 3; i++) {
            if (s.charAt(i) != s.charAt(i + 1)
                    && s.charAt(i) != s.charAt(i + 2)
                    && s.charAt(i + 1) != s.charAt(i + 2))
                count++;
        }
        return count;
    }
}