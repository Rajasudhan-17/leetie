// ──────────────────────────────────────────────────
// Problem  : 1124. Longest Well-Performing Interval
// Difficulty: Medium
// Tags     : Array, Hash Table, Stack, Monotonic Stack, Prefix Sum
// Link     : https://leetcode.com/problems/longest-well-performing-interval/
// Runtime  : 12 ms (beats 72%)
// Memory   : 47024000 (beats 85%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int longestWPI(int[] hours) {
        int res = 0;
        int score = 0;
        Map<Integer, Integer> seen = new HashMap<>();
        
        for (int i = 0; i < hours.length; i++) {
            score += hours[i] > 8 ? 1 : -1;
            
            if (score > 0) {
                res = i + 1;
            } else {
                seen.putIfAbsent(score, i);
                if (seen.containsKey(score - 1)) {
                    res = Math.max(res, i - seen.get(score - 1));
                }
            }
        }
        
        return res;
    }
}