// ──────────────────────────────────────────────────
// Problem  : 187. Repeated DNA Sequences
// Difficulty: Medium
// Tags     : Hash Table, String, Bit Manipulation, Sliding Window, Rolling Hash, Hash Function, Z Algorithm, Boyer–Moore String-Search Algorithm
// Link     : https://leetcode.com/problems/repeated-dna-sequences/
// Runtime  : 457 ms (beats 17%)
// Memory   : 273700000 (beats 8%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
    Set seen = new HashSet(), repeated = new HashSet();
    for (int i = 0; i + 9 < s.length(); i++) {
        String ten = s.substring(i, i + 10);
        if (!seen.add(ten))
            repeated.add(ten);
    }
    return new ArrayList(repeated);
}
}