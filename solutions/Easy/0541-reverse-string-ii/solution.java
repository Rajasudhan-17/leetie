// ──────────────────────────────────────────────────
// Problem  : 541. Reverse String II
// Difficulty: Easy
// Tags     : Two Pointers, String
// Link     : https://leetcode.com/problems/reverse-string-ii/
// Runtime  : 1 ms (beats 96%)
// Memory   : 44832000 (beats 45%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();

        char[] ch = s.toCharArray();
        int start = 0;

        while(start < n){
            int end = Math.min(start + k - 1, n - 1);
            reverse(ch, start, end);
            start += 2*k;
        }

        return new String(ch);

    }
    private void reverse(char[] ch, int l, int r){
        while(l < r){
            char temp = ch[l];
            ch[l] = ch[r];
            ch[r] = temp;

            l++;
            r--;
        }
    }
}