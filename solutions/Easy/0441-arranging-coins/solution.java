// ──────────────────────────────────────────────────
// Problem  : 441. Arranging Coins
// Difficulty: Easy
// Tags     : Math, Binary Search
// Link     : https://leetcode.com/problems/arranging-coins/
// Runtime  : 1 ms (beats 100%)
// Memory   : 42984000 (beats 10%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int arrangeCoins(int n) {
        long left = 0, right = n;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long coins = mid * (mid + 1) / 2;
            
            if (coins == n) {
                return (int) mid;
            }
            
            if (coins < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) right;
    }
}