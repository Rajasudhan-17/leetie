// ──────────────────────────────────────────────────
// Problem  : 3291. Minimum Number of Valid Strings to Form Target I
// Difficulty: Medium
// Tags     : Array, String, Binary Search, Dynamic Programming, Greedy, Trie, Segment Tree, Rolling Hash, String Matching, Hash Function
// Link     : https://leetcode.com/problems/minimum-number-of-valid-strings-to-form-target-i/
// Runtime  : 237 ms (beats 53%)
// Memory   : 62464000 (beats 49%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
    }

    public int minValidStrings(String[] words, String target) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode curr = root;
            for (char c : w.toCharArray()) {
                int idx = c - 'a';
                if (curr.children[idx] == null) {
                    curr.children[idx] = new TrieNode();
                }
                curr = curr.children[idx];
            }
        }

        int n = target.length();
        int[] dp = new int[n + 1];
        java.util.Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            
            TrieNode curr = root;
            for (int j = i; j < n; j++) {
                int idx = target.charAt(j) - 'a';
                if (curr.children[idx] == null) {
                    break;
                }
                curr = curr.children[idx];
                dp[j + 1] = Math.min(dp[j + 1], dp[i] + 1);
            }
        }

        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
}