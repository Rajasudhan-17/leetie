// ──────────────────────────────────────────────────
// Problem  : 1658. Minimum Operations to Reduce X to Zero
// Difficulty: Medium
// Tags     : Array, Hash Table, Binary Search, Sliding Window, Prefix Sum
// Link     : https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
// Runtime  : 5 ms (beats 35%)
// Memory   : 101924000 (beats 76%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minOperations(int[] nums, int x) {
	int sum = 0;
	for (int num: nums) sum += num;

	int maxLength = -1, currSum = 0;
	for (int l=0, r=0; r<nums.length; r++) {
		currSum += nums[r];
		while (l <= r && currSum > sum - x) currSum -= nums[l++];
		if (currSum == sum - x) maxLength = Math.max(maxLength, r-l+1);
	}

	return maxLength == -1 ? -1 : nums.length - maxLength;
}
}