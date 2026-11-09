// ──────────────────────────────────────────────────
// Problem  : 524. Longest Word in Dictionary through Deleting
// Difficulty: Medium
// Tags     : Array, Two Pointers, String, Sorting
// Link     : https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
// Runtime  : 21 ms (beats 24%)
// Memory   : 47104000 (beats 84%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String best = "";
        for (String word : dictionary) {
            int i = 0, j = 0;
            while (i < s.length() && j < word.length()) {
                if (s.charAt(i) == word.charAt(j)) {
                    j++;
                }
                i++;
            }
            if (j == word.length()) {
                if (word.length() > best.length() || (word.length() == best.length() && word.compareTo(best) < 0)) {
                    best = word;
                }
            }
        }
        return best;
    }
}