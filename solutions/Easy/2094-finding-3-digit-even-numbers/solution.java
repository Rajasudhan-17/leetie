// ──────────────────────────────────────────────────
// Problem  : 2094. Finding 3-Digit Even Numbers
// Difficulty: Easy
// Tags     : Array, Hash Table, Recursion, Sorting, Enumeration
// Link     : https://leetcode.com/problems/finding-3-digit-even-numbers/
// Runtime  : 4 ms (beats 94%)
// Memory   : 46312000 (beats 84%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] count = new int[10];
        for (int digit : digits) {
            count[digit]++;
        }
        
        List<Integer> res = new ArrayList<>();
        
        for (int i = 100; i < 999; i += 2) {
            int[] currCount = new int[10];
            int curr = i;
            
            while (curr > 0) {
                currCount[curr % 10]++;
                curr /= 10;
            }
            
            boolean isValid = true;
            for (int j = 0; j < 10; j++) {
                if (currCount[j] > count[j]) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                res.add(i);
            }
        }
        
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        
        return result;
    }
}