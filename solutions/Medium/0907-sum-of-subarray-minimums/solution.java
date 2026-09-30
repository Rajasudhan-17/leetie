// ──────────────────────────────────────────────────
// Problem  : 907. Sum of Subarray Minimums
// Difficulty: Medium
// Tags     : Array, Dynamic Programming, Stack, Monotonic Stack
// Link     : https://leetcode.com/problems/sum-of-subarray-minimums/
// Runtime  : 150 ms (beats 78%)
// Memory   : 69772000 (beats 84%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1000000007;
        java.util.Stack<Integer> st = new java.util.Stack<>();
        long sum = 0;
        
        for (int i = 0; i <= arr.length; i++) {
            while (!st.isEmpty() && (i == arr.length || arr[st.peek()] > arr[i])) {
                int mid = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                long count = (long) (mid - left) * (i - mid) % MOD;
                sum = (sum + count * arr[mid]) % MOD;
            }
            st.push(i);
        }
        
        return (int) sum;
    }
}