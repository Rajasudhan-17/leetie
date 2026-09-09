// ──────────────────────────────────────────────────
// Problem  : 241. Different Ways to Add Parentheses
// Difficulty: Medium
// Tags     : Math, String, Dynamic Programming, Recursion, Memoization, Bracket Sequences
// Link     : https://leetcode.com/problems/different-ways-to-add-parentheses/
// Runtime  : 2 ms (beats 86%)
// Memory   : 43992000 (beats 68%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); ++i) {
            char oper = expression.charAt(i);
            if (oper == '+' || oper == '-' || oper == '*') {
                List<Integer> s1 = diffWaysToCompute(expression.substring(0, i));
                List<Integer> s2 = diffWaysToCompute(expression.substring(i + 1));
                for (int a : s1) {
                    for (int b : s2) {
                        if (oper == '+') res.add(a + b);
                        else if (oper == '-') res.add(a - b);
                        else if (oper == '*') res.add(a * b);
                    }
                }
            }
        }
        if (res.isEmpty()) res.add(Integer.parseInt(expression));
        return res;
    }
}