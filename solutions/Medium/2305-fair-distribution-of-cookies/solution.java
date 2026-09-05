// ──────────────────────────────────────────────────
// Problem  : 2305. Fair Distribution of Cookies
// Difficulty: Medium
// Tags     : Array, Dynamic Programming, Backtracking, Bit Manipulation, Bitmask
// Link     : https://leetcode.com/problems/fair-distribution-of-cookies/
// Runtime  : 373 ms (beats 26%)
// Memory   : 42680000 (beats 51%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    int ans = Integer.MAX_VALUE;

    void helper(int[] cookies, int start, int k, int[] temp) {
        if (start == cookies.length) {
            int max = 0;
            for (int c : temp)
                max = Math.max(max, c);
            ans = Math.min(ans, max);
            return;
        }
        for (int i = 0; i < k; i++) {
            temp[i] += cookies[start];
            helper(cookies, start + 1, k, temp);
            temp[i] -= cookies[start];
        }
    }

    public int distributeCookies(int[] cookies, int k) {
        helper(cookies, 0, k, new int[k]);
        return ans;
    }
}