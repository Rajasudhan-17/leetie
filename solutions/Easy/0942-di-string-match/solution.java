// ──────────────────────────────────────────────────
// Problem  : 942. DI String Match
// Difficulty: Easy
// Tags     : Array, Two Pointers, String, Greedy
// Link     : https://leetcode.com/problems/di-string-match/
// Runtime  : 2 ms (beats 99%)
// Memory   : 47340000 (beats 25%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] ans = new int[n + 1];
        int low = 0;
        int high = n;
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                ans[i] = low++;
            } else {
                ans[i] = high--;
            }
        }
        ans[n] = low;
        
        return ans;
    }
}