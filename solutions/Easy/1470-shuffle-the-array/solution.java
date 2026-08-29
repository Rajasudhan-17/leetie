// ──────────────────────────────────────────────────
// Problem  : 1470. Shuffle the Array
// Difficulty: Easy
// Tags     : Array
// Link     : https://leetcode.com/problems/shuffle-the-array/
// Runtime  : 0 ms (beats 100%)
// Memory   : 46460000 (beats 62%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res=new int[2*n];
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                res[i]=nums[i/2];
            }
            else{
                res[i]=nums[n+i/2];
            }
        }
        return res;
    }
}