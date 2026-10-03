// ──────────────────────────────────────────────────
// Problem  : 481. Magical String
// Difficulty: Medium
// Tags     : Two Pointers, String
// Link     : https://leetcode.com/problems/magical-string/
// Runtime  : 3 ms (beats 100%)
// Memory   : 44016000 (beats 57%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int magicalString(int n) {
        if (n <= 0) return 0;
        if (n <= 3) return 1;
        
        int[] a = new int[n + 1];
        a[0] = 1;
        a[1] = 2;
        a[2] = 2;
        
        int head = 2;
        int tail = 3;
        int num = 1;
        int result = 1;
        
        while (tail < n) {
            for (int i = 0; i < a[head]; i++) {
                a[tail] = num;
                if (num == 1 && tail < n) {
                    result++;
                }
                tail++;
            }
            num ^= 3;
            head++;
        }
        
        return result;
    }
}