// ──────────────────────────────────────────────────
// Problem  : 673. Number of Longest Increasing Subsequence
// Difficulty: Medium
// Tags     : Array, Dynamic Programming, Binary Indexed Tree, Segment Tree, Longest Increasing Subsequence
// Link     : https://leetcode.com/problems/number-of-longest-increasing-subsequence/
// Runtime  : 20 ms (beats 56%)
// Memory   : 45392000 (beats 77%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int[] lengths = new int[n];
        int[] counts = new int[n];
        java.util.Arrays.fill(lengths, 1);
        java.util.Arrays.fill(counts, 1);

        int maxLength = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (lengths[j] + 1 > lengths[i]) {
                        lengths[i] = lengths[j] + 1;
                        counts[i] = counts[j];
                    } else if (lengths[j] + 1 == lengths[i]) {
                        counts[i] += counts[j];
                    }
                }
            }
            maxLength = Math.max(maxLength, lengths[i]);
        }

        int numberOfLIS = 0;
        for (int i = 0; i < n; i++) {
            if (lengths[i] == maxLength) {
                numberOfLIS += counts[i];
            }
        }

        return numberOfLIS;
    }
}