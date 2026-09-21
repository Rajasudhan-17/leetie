// ──────────────────────────────────────────────────
// Problem  : 309. Best Time to Buy and Sell Stock with Cooldown
// Difficulty: Medium
// Tags     : Array, Dynamic Programming
// Link     : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
// Runtime  : 0 ms (beats 100%)
// Memory   : 43232000 (beats 88%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int maxProfit(int[] prices) {
        int sold = 0;
        int hold = Integer.MIN_VALUE;
        int rest = 0;
        
        for (int price : prices) {
            int prevSold = sold;
            sold = hold + price;
            hold = Math.max(hold, rest - price);
            rest = Math.max(rest, prevSold);
        }
        
        return Math.max(sold, rest);
    }
}