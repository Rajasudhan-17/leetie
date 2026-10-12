// ──────────────────────────────────────────────────
// Problem  : 1297. Maximum Number of Occurrences of a Substring
// Difficulty: Medium
// Tags     : Hash Table, String, Sliding Window
// Link     : https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/
// Runtime  : 63 ms (beats 33%)
// Memory   : 48748000 (beats 47%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> map = new HashMap<>();
        int maxOccurrences = 0;
        
        for (int i = 0; i <= s.length() - minSize; i++) {
            String sub = s.substring(i, i + minSize);
            Set<Character> uniqueChars = new HashSet<>();
            
            for (char c : sub.toCharArray()) {
                uniqueChars.add(c);
            }
            
            if (uniqueChars.size() <= maxLetters) {
                int count = map.getOrDefault(sub, 0) + 1;
                map.put(sub, count);
                maxOccurrences = Math.max(maxOccurrences, count);
            }
        }
        
        return maxOccurrences;
    }
}