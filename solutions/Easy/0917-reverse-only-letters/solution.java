// ──────────────────────────────────────────────────
// Problem  : 917. Reverse Only Letters
// Difficulty: Easy
// Tags     : Two Pointers, String
// Link     : https://leetcode.com/problems/reverse-only-letters/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42096000 (beats 97%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String reverseOnlyLetters(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (!Character.isLetter(arr[left])) {
                left++;
            } else if (!Character.isLetter(arr[right])) {
                right--;
            } else {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return new String(arr);
    }
}