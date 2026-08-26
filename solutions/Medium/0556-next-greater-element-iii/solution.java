// ──────────────────────────────────────────────────
// Problem  : 556. Next Greater Element III
// Difficulty: Medium
// Tags     : Math, Two Pointers, String
// Link     : https://leetcode.com/problems/next-greater-element-iii/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42156000 (beats 42%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int nextGreaterElement(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int i = digits.length - 2;
        
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }
        
        if (i < 0) {
            return -1;
        }
        
        int j = digits.length - 1;
        while (j >= 0 && digits[j] <= digits[i]) {
            j--;
        }
        
        swap(digits, i, j);
        reverse(digits, i + 1, digits.length - 1);
        
        long result = Long.parseLong(new String(digits));
        return result <= Integer.MAX_VALUE ? (int) result : -1;
    }
    
    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    private void reverse(char[] a, int i, int j) {
        while (i < j) {
            swap(a, i++, j--);
        }
    }
}