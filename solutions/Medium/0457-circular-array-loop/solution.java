// ──────────────────────────────────────────────────
// Problem  : 457. Circular Array Loop
// Difficulty: Medium
// Tags     : Array, Hash Table, Two Pointers, Floyd's Cycle Finding Algorithm
// Link     : https://leetcode.com/problems/circular-array-loop/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42640000 (beats 85%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;
            
            int slow = i;
            int fast = getNext(nums, i);
            
            while (nums[fast] * nums[i] > 0 && nums[getNext(nums, fast)] * nums[i] > 0) {
                if (slow == fast) {
                    if (slow == getNext(nums, slow)) {
                        break;
                    }
                    return true;
                }
                slow = getNext(nums, slow);
                fast = getNext(nums, getNext(nums, fast));
            }
            
            int curr = i;
            int val = nums[i];
            while (nums[curr] * val > 0) {
                int next = getNext(nums, curr);
                nums[curr] = 0;
                curr = next;
            }
        }
        return false;
    }

    private int getNext(int[] nums, int i) {
        int n = nums.length;
        return (((i + nums[i]) % n) + n) % n;
    }
}