// ──────────────────────────────────────────────────
// Problem  : 89. Gray Code
// Difficulty: Medium
// Tags     : Math, Backtracking, Bit Manipulation
// Link     : https://leetcode.com/problems/gray-code/
// Runtime  : 5 ms (beats 54%)
// Memory   : 53832000 (beats 23%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public List<Integer> grayCode(int n) {
        int total=1<<n;
        List<Integer> gray=new ArrayList<>();
        for(int i=0;i<total;i++){
            gray.add(i^(i>>1));
        }
        return gray;
    }
}