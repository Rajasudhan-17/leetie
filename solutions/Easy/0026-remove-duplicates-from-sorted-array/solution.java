// ──────────────────────────────────────────────────
// Problem  : 26. Remove Duplicates from Sorted Array
// Difficulty: Easy
// Tags     : Array, Two Pointers
// Link     : https://leetcode.com/problems/remove-duplicates-from-sorted-array/
// Runtime  : 1 ms (beats 77%)
// Memory   : 46848000 (beats 24%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            }
            
        }
        return i+1;
    }
}