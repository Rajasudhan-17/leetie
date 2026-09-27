// ──────────────────────────────────────────────────
// Problem  : 299. Bulls and Cows
// Difficulty: Medium
// Tags     : Hash Table, String, Counting
// Link     : https://leetcode.com/problems/bulls-and-cows/
// Runtime  : 3 ms (beats 96%)
// Memory   : 43564000 (beats 62%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        
        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if (s == g) {
                bulls++;
            } else {
                if (numbers[s] < 0) cows++;
                if (numbers[g] > 0) cows++;
                numbers[s]++;
                numbers[g]--;
            }
        }
        
        return bulls + "A" + cows + "B";
    }
}