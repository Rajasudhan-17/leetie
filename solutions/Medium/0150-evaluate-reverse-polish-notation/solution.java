// ──────────────────────────────────────────────────
// Problem  : 150. Evaluate Reverse Polish Notation
// Difficulty: Medium
// Tags     : Array, Math, Stack
// Link     : https://leetcode.com/problems/evaluate-reverse-polish-notation/
// Runtime  : 3 ms (beats 99%)
// Memory   : 45028000 (beats 90%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int top = 0;
        
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack[top - 2] += stack[top - 1];
                    top--;
                    break;
                case "-":
                    stack[top - 2] -= stack[top - 1];
                    top--;
                    break;
                case "*":
                    stack[top - 2] *= stack[top - 1];
                    top--;
                    break;
                case "/":
                    stack[top - 2] /= stack[top - 1];
                    top--;
                    break;
                default:
                    stack[top++] = Integer.parseInt(token);
            }
        }
        
        return stack[0];
    }
}