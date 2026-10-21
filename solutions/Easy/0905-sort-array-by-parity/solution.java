// ──────────────────────────────────────────────────
// Problem  : 905. Sort Array By Parity
// Difficulty: Easy
// Tags     : Array, Two Pointers, Sorting
// Link     : https://leetcode.com/problems/sort-array-by-parity/
// Runtime  : 1 ms (beats 47%)
// Memory   : 46108000 (beats 99%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            if (nums[left] % 2 != 0 && nums[right] % 2 == 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            
            if (nums[left] % 2 == 0) left++;
            if (nums[right] % 2 != 0) right--;
        }
        
        return nums;
    }
}