// ──────────────────────────────────────────────────
// Problem  : 3477. Fruits Into Baskets II
// Difficulty: Easy
// Tags     : Array, Binary Search, Segment Tree, Simulation, Ordered Set
// Link     : https://leetcode.com/problems/fruits-into-baskets-ii/
// Runtime  : 3 ms (beats 13%)
// Memory   : 46632000 (beats 13%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        boolean[] used = new boolean[n];
        int unplaced = 0;
        
        for (int fruit : fruits) {
            boolean placed = false;
            for (int j = 0; j < n; j++) {
                if (!used[j] && baskets[j] >= fruit) {
                    used[j] = true;
                    placed = true;
                    break;
                }
            }
            if (!placed) {
                unplaced++;
            }
        }
        
        return unplaced;
    }
}