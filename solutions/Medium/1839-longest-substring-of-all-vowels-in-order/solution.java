// ──────────────────────────────────────────────────
// Problem  : 1839. Longest Substring Of All Vowels in Order
// Difficulty: Medium
// Tags     : String, Sliding Window
// Link     : https://leetcode.com/problems/longest-substring-of-all-vowels-in-order/
// Runtime  : 19 ms (beats 85%)
// Memory   : 50720000 (beats 73%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int longestBeautifulSubstring(String word) {
        int maxLen = 0;
        int currentLen = 1;
        int uniqueVowels = 1;

        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                currentLen++;
            } else if (word.charAt(i) > word.charAt(i - 1)) {
                currentLen++;
                uniqueVowels++;
            } else {
                currentLen = 1;
                uniqueVowels = 1;
            }

            if (uniqueVowels == 5) {
                maxLen = Math.max(maxLen, currentLen);
            }
        }

        return maxLen;
    }
}