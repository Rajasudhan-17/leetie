// ──────────────────────────────────────────────────
// Problem  : 423. Reconstruct Original Digits from English
// Difficulty: Medium
// Tags     : Hash Table, Math, String
// Link     : https://leetcode.com/problems/reconstruct-original-digits-from-english/
// Runtime  : 4 ms (beats 98%)
// Memory   : 46384000 (beats 51%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String originalDigits(String s) {
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        
        int[] digitCount = new int[10];
        
        // Step 1: Identify digits with uniquely identifying characters
        digitCount[0] = charCount['z' - 'a']; // 'z' is only in "zero"
        digitCount[2] = charCount['w' - 'a']; // 'w' is only in "two"
        digitCount[4] = charCount['u' - 'a']; // 'u' is only in "four"
        digitCount[6] = charCount['x' - 'a']; // 'x' is only in "six"
        digitCount[8] = charCount['g' - 'a']; // 'g' is only in "eight"
        
        // Step 2: Identify remaining digits by subtracting known overlapping counts
        digitCount[3] = charCount['h' - 'a'] - digitCount[8]; // 'h' is in "three" and "eight"
        digitCount[5] = charCount['f' - 'a'] - digitCount[4]; // 'f' is in "five" and "four"
        digitCount[7] = charCount['s' - 'a'] - digitCount[6]; // 's' is in "seven" and "six"
        
        // 'i' is in "nine", "five", "six", and "eight"
        digitCount[9] = charCount['i' - 'a'] - digitCount[5] - digitCount[6] - digitCount[8]; 
        
        // 'o' is in "one", "zero", "two", and "four"
        digitCount[1] = charCount['o' - 'a'] - digitCount[0] - digitCount[2] - digitCount[4]; 
        
        // Step 3: Build the final string in ascending order
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j < digitCount[i]; j++) {
                sb.append(i);
            }
        }
        
        return sb.toString();
    }
}