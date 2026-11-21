// ──────────────────────────────────────────────────
// Problem  : 373. Find K Pairs with Smallest Sums
// Difficulty: Medium
// Tags     : Array, Heap (Priority Queue)
// Link     : https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
// Runtime  : 35 ms (beats 52%)
// Memory   : 138540000 (beats 34%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(nums1[a[0]] + nums2[a[1]], nums1[b[0]] + nums2[b[1]])
        );
        int limit = Math.min(k, nums1.length);
        for (int i = 0; i < limit; i++) {
            pq.offer(new int[]{i, 0});
        }
        while (!pq.isEmpty() && res.size() < k) {
            int[] cur = pq.poll();
            int i = cur[0];
            int j = cur[1];
            res.add(Arrays.asList(nums1[i], nums2[j]));
            if (j + 1 < nums2.length) {
                pq.offer(new int[]{i, j + 1});
            }
        }
        return res;
    }
}