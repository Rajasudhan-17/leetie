// ──────────────────────────────────────────────────
// Problem  : 974. Subarray Sums Divisible by K
// Difficulty: Medium
// Tags     : Array, Hash Table, Prefix Sum
// Link     : https://leetcode.com/problems/subarray-sums-divisible-by-k/
// Runtime  : 4 ms (beats 91%)
// Memory   : 48456000 (beats 95%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] count = new int[k];
        count[0] = 1;
        int prefixSum = 0;
        int ans = 0;
        
        for (int num : nums) {
            prefixSum = (prefixSum + num % k + k) % k;
            ans += count[prefixSum];
            count[prefixSum]++;
        }
        
        return ans;
    }
}