// ──────────────────────────────────────────────────
// Problem  : 410. Split Array Largest Sum
// Difficulty: Hard
// Tags     : Array, Binary Search, Dynamic Programming, Greedy, Prefix Sum
// Link     : https://leetcode.com/problems/split-array-largest-sum/
// Runtime  : 0 ms (beats 100%)
// Memory   : 43064000 (beats 50%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {

    public boolean checker(int[] boards, int mid, int k) {
        int count = 1;
        int sum = 0;

        for (int i = 0; i < boards.length; i++) {
            if (sum + boards[i] <= mid) {
                sum += boards[i];
            }
            else {
                if (boards[i] > mid)
                    return false;

                count++;
                sum = boards[i];
            }
        }

        return count <= k;
    }

    public int splitArray(int[] boards, int k) {
        int low = 0;
        int high = 1000000000;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (checker(boards, mid, k)) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return ans;
    }
}