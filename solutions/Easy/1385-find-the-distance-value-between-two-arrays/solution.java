// ──────────────────────────────────────────────────
// Problem  : 1385. Find the Distance Value Between Two Arrays
// Difficulty: Easy
// Tags     : Array, Two Pointers, Binary Search, Sorting
// Link     : https://leetcode.com/problems/find-the-distance-value-between-two-arrays/
// Runtime  : 9 ms (beats 18%)
// Memory   : 46736000 (beats 10%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        
        for (int x : arr1) {
            int left = 0;
            int right = arr2.length - 1;
            boolean valid = true;
            
            while (left <= right) {
                int mid = left + (right - left) / 2;
                
                if (Math.abs(arr2[mid] - x) <= d) {
                    valid = false;
                    break;
                } else if (arr2[mid] < x) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            
            if (valid) {
                count++;
            }
        }
        
        return count;
    }
}