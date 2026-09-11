// ──────────────────────────────────────────────────
// Problem  : 475. Heaters
// Difficulty: Medium
// Tags     : Array, Two Pointers, Binary Search, Sorting
// Link     : https://leetcode.com/problems/heaters/
// Runtime  : 19 ms (beats 67%)
// Memory   : 47392000 (beats 99%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int maxRadius = 0;
        
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            
            if (index < 0) {
                index = -(index + 1);
                int leftDist = index > 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
                int rightDist = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
                maxRadius = Math.max(maxRadius, Math.min(leftDist, rightDist));
            }
        }
        
        return maxRadius;
    }
}