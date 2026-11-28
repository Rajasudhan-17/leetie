// ──────────────────────────────────────────────────
// Problem  : 1477. Find Two Non-overlapping Sub-arrays Each With Target Sum
// Difficulty: Medium
// Tags     : Array, Hash Table, Binary Search, Dynamic Programming, Sliding Window
// Link     : https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/
// Runtime  : 8 ms (beats 33%)
// Memory   : 96644000 (beats 31%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int inf = n + 1;
        int[] best = new int[n];
        Arrays.fill(best, inf);
        int ans = inf;
        int currSum = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            currSum += arr[right];
            while (currSum > target) {
                currSum -= arr[left];
                left++;
            }

            if (currSum == target) {
                int currLen = right - left + 1;
                if (left > 0 && best[left - 1] != inf) {
                    ans = Math.min(ans, currLen + best[left - 1]);
                }
                best[right] = Math.min(right > 0 ? best[right - 1] : inf, currLen);
            } else {
                best[right] = right > 0 ? best[right - 1] : inf;
            }
        }

        return ans == inf ? -1 : ans;
    }
}