// ──────────────────────────────────────────────────
// Problem  : 918. Maximum Sum Circular Subarray
// Difficulty: Medium
// Tags     : Array, Divide and Conquer, Dynamic Programming, Queue, Monotonic Queue
// Link     : https://leetcode.com/problems/maximum-sum-circular-subarray/
// Runtime  : 7 ms (beats 51%)
// Memory   : 51140000 (beats 42%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = nums[0];
        int minSum = nums[0];
        int currMaxSum = nums[0];
        int currMinSum = nums[0];
        int totalSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {

            currMaxSum = Math.max(currMaxSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currMaxSum);
            currMinSum = Math.min(currMinSum + nums[i], nums[i]);
            minSum = Math.min(minSum, currMinSum);
            totalSum += nums[i];
        }

        int circularSum = totalSum - minSum;
        
        if (circularSum == 0) {
            return maxSum;
        }
        return Math.max(maxSum, circularSum);
    }
}