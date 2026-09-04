// ──────────────────────────────────────────────────
// Problem  : 1984. Minimum Difference Between Highest and Lowest of K Scores
// Difficulty: Easy
// Tags     : Array, Sliding Window, Sorting
// Link     : https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/
// Runtime  : 8 ms (beats 91%)
// Memory   : 46952000 (beats 34%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = nums[k - 1] - nums[0];
        for (int i = 0; i + k <= n; i++) {
            ans = Math.min(ans, nums[i + k - 1] - nums[i]);
        }
        return ans;
    }
}