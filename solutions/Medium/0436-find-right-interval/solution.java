// ──────────────────────────────────────────────────
// Problem  : 436. Find Right Interval
// Difficulty: Medium
// Tags     : Array, Binary Search, Sorting
// Link     : https://leetcode.com/problems/find-right-interval/
// Runtime  : 22 ms (beats 41%)
// Memory   : 50328000 (beats 68%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] result = new int[n];
        java.util.TreeMap<Integer, Integer> map = new java.util.TreeMap<>();
        
        for (int i = 0; i < n; i++) {
            map.put(intervals[i][0], i);
        }
        
        for (int i = 0; i < n; i++) {
            java.util.Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i][1]);
            result[i] = (entry != null) ? entry.getValue() : -1;
        }
        
        return result;
    }
}