// ──────────────────────────────────────────────────
// Problem  : 2424. Longest Uploaded Prefix
// Difficulty: Medium
// Tags     : Hash Table, Binary Search, Union-Find, Design, Binary Indexed Tree, Segment Tree, Heap (Priority Queue), Ordered Set
// Link     : https://leetcode.com/problems/longest-uploaded-prefix/
// Runtime  : 30 ms (beats 77%)
// Memory   : 132300000 (beats 96%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class LUPrefix {
    private boolean[] uploaded;
    private int longestPrefix;

    public LUPrefix(int n) {
        uploaded = new boolean[n + 2]; 
        longestPrefix = 0;
    }
    
    public void upload(int video) {
        uploaded[video] = true;
        
        while (uploaded[longestPrefix + 1]) {
            longestPrefix++;
        }
    }
    
    public int longest() {
        return longestPrefix;
    }
}