// ──────────────────────────────────────────────────
// Problem  : 901. Online Stock Span
// Difficulty: Medium
// Tags     : Stack, Design, Monotonic Stack, Data Stream
// Link     : https://leetcode.com/problems/online-stock-span/
// Runtime  : 32 ms (beats 50%)
// Memory   : 56200000 (beats 13%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class StockSpanner {
    Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }
        stack.push(new int[]{price, span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */