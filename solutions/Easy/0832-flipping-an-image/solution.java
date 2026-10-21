// ──────────────────────────────────────────────────
// Problem  : 832. Flipping an Image
// Difficulty: Easy
// Tags     : Array, Two Pointers, Bit Manipulation, Matrix, Simulation
// Link     : https://leetcode.com/problems/flipping-an-image/
// Runtime  : 0 ms (beats 100%)
// Memory   : 45060000 (beats 99%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left <= right) {
                int temp = image[i][left] ^ 1;
                image[i][left] = image[i][right] ^ 1;
                image[i][right] = temp;
                left++;
                right--;
            }
        }
        return image;
    }
}
