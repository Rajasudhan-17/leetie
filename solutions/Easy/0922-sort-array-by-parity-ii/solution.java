// ──────────────────────────────────────────────────
// Problem  : 922. Sort Array By Parity II
// Difficulty: Easy
// Tags     : Array, Two Pointers, Sorting
// Link     : https://leetcode.com/problems/sort-array-by-parity-ii/
// Runtime  : 3 ms (beats 73%)
// Memory   : 47892000 (beats 83%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int evenIdx = 0;
        int oddIdx = 1;
        int n = nums.length;

        while (evenIdx < n && oddIdx < n) {
            if (nums[evenIdx] % 2 == 0) {
                evenIdx += 2;
            } else if (nums[oddIdx] % 2 == 1) {
                oddIdx += 2;
            } else {
                int temp = nums[evenIdx];
                nums[evenIdx] = nums[oddIdx];
                nums[oddIdx] = temp;
                evenIdx += 2;
                oddIdx += 2;
            }
        }

        return nums;
    }
}