// ──────────────────────────────────────────────────
// Problem  : 1700. Number of Students Unable to Eat Lunch
// Difficulty: Easy
// Tags     : Array, Stack, Queue, Simulation
// Link     : https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
// Runtime  : 0 ms (beats 100%)
// Memory   : 43160000 (beats 76%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] counts = new int[2];
        for (int student : students) {
            counts[student]++;
        }
        
        for (int i = 0; i < sandwiches.length; i++) {
            if (counts[sandwiches[i]] > 0) {
                counts[sandwiches[i]]--;
            } else {
                return sandwiches.length - i;
            }
        }
        
        return 0;
    }
}