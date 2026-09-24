// ──────────────────────────────────────────────────
// Problem  : 3483. Unique 3-Digit Even Numbers
// Difficulty: Easy
// Tags     : Array, Hash Table, Recursion, Enumeration
// Link     : https://leetcode.com/problems/unique-3-digit-even-numbers/
// Runtime  : 10 ms (beats 16%)
// Memory   : 46856000 (beats 11%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int totalNumbers(int[] digits) {
        int[] count = new int[10];
        for (int digit : digits) {
            count[digit]++;
        }
        
        int ans = 0;
        for (int i = 100; i <= 998; i += 2) {
            int[] currCount = new int[10];
            currCount[i % 10]++;
            currCount[(i / 10) % 10]++;
            currCount[i / 100]++;
            
            boolean possible = true;
            for (int j = 0; j < 10; j++) {
                if (currCount[j] > count[j]) {
                    possible = false;
                    break;
                }
            }
            if (possible) {
                ans++;
            }
        }
        return ans;
    }
}