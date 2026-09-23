// ──────────────────────────────────────────────────
// Problem  : 1668. Maximum Repeating Substring
// Difficulty: Easy
// Tags     : String, Dynamic Programming, String Matching
// Link     : https://leetcode.com/problems/maximum-repeating-substring/
// Runtime  : 1 ms (beats 90%)
// Memory   : 42884000 (beats 84%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int maxRepeating(String sequence, String word) {
        int count = 0;
        StringBuilder sb = new StringBuilder(word);
        while (sequence.contains(sb.toString())) {
            count++;
            sb.append(word);
        }
        return count;
    }
}