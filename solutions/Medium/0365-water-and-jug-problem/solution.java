// ──────────────────────────────────────────────────
// Problem  : 365. Water and Jug Problem
// Difficulty: Medium
// Tags     : Math, Depth-First Search, Breadth-First Search, Bézout's Lemma, Euclidean Algorithm, Greatest Common Divisor, Extended Euclidean Algorithm
// Link     : https://leetcode.com/problems/water-and-jug-problem/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42172000 (beats 41%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        if (x + y < target) {
            return false;
        }
        if (x == target || y == target || x + y == target) {
            return true;
        }
        return target % gcd(x, y) == 0;
    }
    
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}