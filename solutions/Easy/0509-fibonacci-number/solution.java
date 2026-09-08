// ──────────────────────────────────────────────────
// Problem  : 509. Fibonacci Number
// Difficulty: Easy
// Tags     : Math, Dynamic Programming, Recursion, Memoization
// Link     : https://leetcode.com/problems/fibonacci-number/
// Runtime  : 0 ms (beats 100%)
// Memory   : 41860000 (beats 86%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int fibo(int n,int[] dp){
        if(n<=1){
            return n;
        }
        if(dp[n]!=-1) return dp[n];
        dp[n]=fibo(n-1,dp)+fibo(n-2,dp);
        return dp[n];

    }
    public int fib(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return fibo(n,dp);
        
    }
}