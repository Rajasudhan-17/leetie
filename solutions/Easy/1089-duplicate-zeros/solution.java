// ──────────────────────────────────────────────────
// Problem  : 1089. Duplicate Zeros
// Difficulty: Easy
// Tags     : Array, Two Pointers
// Link     : https://leetcode.com/problems/duplicate-zeros/
// Runtime  : 1 ms (beats 100%)
// Memory   : 46840000 (beats 61%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int count = 0;
        
        for (int num : arr) {
            if (num == 0) {
                count++;
            }
        }
        
        int i = n - 1;
        int j = n + count - 1;
        
        while (i >= 0) {
            if (j < n) {
                arr[j] = arr[i];
            }
            if (arr[i] == 0) {
                j--;
                if (j < n) {
                    arr[j] = 0;
                }
            }
            i--;
            j--;
        }
    }
}