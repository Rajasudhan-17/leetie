// ──────────────────────────────────────────────────
// Problem  : 1016. Binary String With Substrings Representing 1 To N
// Difficulty: Medium
// Tags     : Hash Table, String, Bit Manipulation, Sliding Window
// Link     : https://leetcode.com/problems/binary-string-with-substrings-representing-1-to-n/
// Runtime  : 7 ms (beats 10%)
// Memory   : 44360000 (beats 5%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean queryString(String S, int N) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < S.length(); i++){
            for(int j = i + 1; j <= S.length(); j++){
                int v = Integer.parseInt(S.substring(i, j), 2);
                
                if(v > 0 && v <= N){
                    set.add(v);
                } else {
                    break;
                }
            }
        }
        
        return set.size() == N;
    }
}