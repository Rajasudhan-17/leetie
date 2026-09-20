// ──────────────────────────────────────────────────
// Problem  : 357. Count Numbers with Unique Digits
// Difficulty: Medium
// Tags     : Math, Dynamic Programming, Backtracking
// Link     : https://leetcode.com/problems/count-numbers-with-unique-digits/
// Runtime  : 0 ms (beats 100%)
// Memory   : 41724000 (beats 92%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        
        int count = 10;
        int currentUniqueDigits = 9;
        int availableNumbers = 9;
        
        while (n > 1 && availableNumbers > 0) {
            currentUniqueDigits *= availableNumbers;
            count += currentUniqueDigits;
            availableNumbers--;
            n--;
        }
        
        return count;
    }
}