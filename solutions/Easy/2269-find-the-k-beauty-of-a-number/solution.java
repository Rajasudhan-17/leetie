// ──────────────────────────────────────────────────
// Problem  : 2269. Find the K-Beauty of a Number
// Difficulty: Easy
// Tags     : Math, String, Sliding Window
// Link     : https://leetcode.com/problems/find-the-k-beauty-of-a-number/
// Runtime  : 1 ms (beats 93%)
// Memory   : 42248000 (beats 56%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int divisorSubstrings(int num, int k) {

        String s = String.valueOf(num);
        int count = 0;

        for (int i = 0; i <= s.length() - k; i++) {

            String sub = s.substring(i, i + k);
            int n1 = Integer.parseInt(sub);

            if (n1 != 0 && num % n1 == 0) {
                count++;
            }
        }

        return count;
    }
}