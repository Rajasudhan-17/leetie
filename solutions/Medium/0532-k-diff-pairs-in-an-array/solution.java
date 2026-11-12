// ──────────────────────────────────────────────────
// Problem  : 532. K-diff Pairs in an Array
// Difficulty: Medium
// Tags     : Array, Hash Table, Two Pointers, Binary Search, Sorting
// Link     : https://leetcode.com/problems/k-diff-pairs-in-an-array/
// Runtime  : 12 ms (beats 46%)
// Memory   : 45652000 (beats 96%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        
        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int count = 0;
        for (int key : map.keySet()) {
            if (k == 0) {
                if (map.get(key) >= 2) {
                    count++;
                }
            } else {
                if (map.containsKey(key + k)) {
                    count++;
                }
            }
        }
        
        return count;
    }
}