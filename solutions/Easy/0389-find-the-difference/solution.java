// ──────────────────────────────────────────────────
// Problem  : 389. Find the Difference
// Difficulty: Easy
// Tags     : Hash Table, String, Bit Manipulation, Sorting
// Link     : https://leetcode.com/problems/find-the-difference/
// Runtime  : 11 ms (beats 15%)
// Memory   : 43556000 (beats 8%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();
        
        for (char c : t.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        
        for (char c : s.toCharArray()) {
            count.put(c, count.get(c) - 1);
            if (count.get(c) == 0) {
                count.remove(c);
            }
        }
        
        return (char) count.keySet().toArray()[0];        
    }
}