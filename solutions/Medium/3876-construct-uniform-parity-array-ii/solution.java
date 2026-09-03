// ──────────────────────────────────────────────────
// Problem  : 3876. Construct Uniform Parity Array II
// Difficulty: Medium
// Tags     : Array, Math
// Link     : https://leetcode.com/problems/construct-uniform-parity-array-ii/
// Runtime  : 2 ms (beats 100%)
// Memory   : 121676000 (beats 55%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean uniformArray(int[] nums1) {
        // Find the minimum element in the array
        int mn = nums1[0];
        for (int num : nums1) {
            if (num < mn) {
                mn = num;
            }
        }
        
        // If the minimum element is odd, we can make all elements odd
        if (mn % 2 != 0) {
            return true;
        } else {
            // If the minimum is even, all elements MUST already be even
            for (int num : nums1) {
                if (num % 2 != 0) {
                    return false; // Found an odd number, impossible to convert
                }
            }
        }
        return true;
    }
}