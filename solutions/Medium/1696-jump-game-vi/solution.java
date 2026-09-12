// ──────────────────────────────────────────────────
// Problem  : 1696. Jump Game VI
// Difficulty: Medium
// Tags     : Array, Dynamic Programming, Queue, Heap (Priority Queue), Monotonic Queue
// Link     : https://leetcode.com/problems/jump-game-vi/
// Runtime  : 22 ms (beats 94%)
// Memory   : 88916000 (beats 26%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>(); 
        dq.offer(0);
        for (int i = 1; i < n; ++i) {
            nums[i] = nums[dq.peekFirst()] + nums[i];

            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.pollLast(); 
            dq.offerLast(i);

            if (i - dq.peekFirst() >= k) dq.pollFirst();
        }
        return nums[n - 1];
    }
}