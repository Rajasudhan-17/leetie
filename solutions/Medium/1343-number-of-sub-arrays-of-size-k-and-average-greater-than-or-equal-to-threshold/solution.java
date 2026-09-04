// ──────────────────────────────────────────────────
// Problem  : 1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
// Difficulty: Medium
// Tags     : Array, Sliding Window
// Link     : https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
// Runtime  : 3 ms (beats 87%)
// Memory   : 72048000 (beats 8%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) 
    {
        int n = arr.length;

        int left = 0;
        int sum = 0;
        int windowCount = 0;

        for(int right = 0; right < n; right++)
        {
            sum = sum + arr[right];

            int windowSize = right - left + 1;

            if(windowSize == k)
            {
                if(sum >= k * threshold)
                {
                    windowCount++;
                }
                
                sum = sum - arr[left];
                left++;
            }
        }
  
        return windowCount;
    }
}
