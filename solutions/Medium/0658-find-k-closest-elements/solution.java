// ──────────────────────────────────────────────────
// Problem  : 658. Find K Closest Elements
// Difficulty: Medium
// Tags     : Array, Two Pointers, Binary Search, Sliding Window, Sorting, Heap (Priority Queue)
// Link     : https://leetcode.com/problems/find-k-closest-elements/
// Runtime  : 5 ms (beats 55%)
// Memory   : 47524000 (beats 90%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int start = 0;
        int end = arr.length - 1;
        while (end - start >= k) {
            if (Math.abs(arr[start] - x) > Math.abs(arr[end] - x)) {
                start++;
            } else {
                end--;
            }
        }

        List<Integer> result = new ArrayList<>(k);
        for (int i = start; i <= end; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}