// ──────────────────────────────────────────────────
// Problem  : 473. Matchsticks to Square
// Difficulty: Medium
// Tags     : Array, Dynamic Programming, Backtracking, Bit Manipulation, Bitmask
// Link     : https://leetcode.com/problems/matchsticks-to-square/
// Runtime  : 7 ms (beats 78%)
// Memory   : 42804000 (beats 71%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int len : matchsticks) {
            sum += len;
        }
        
        if (sum % 4 != 0) {
            return false;
        }
        
        int target = sum / 4;
        
        java.util.Arrays.sort(matchsticks);
        int n = matchsticks.length;
        if (matchsticks[n - 1] > target) {
            return false;
        }
        
        int[] sides = new int[4];
        return dfs(matchsticks, n - 1, sides, target);
    }
    
    private boolean dfs(int[] matchsticks, int index, int[] sides, int target) {
        if (index < 0) {
            return sides[0] == target && sides[1] == target && sides[2] == target && sides[3] == target;
        }
        
        int currentMatch = matchsticks[index];
        
        for (int i = 0; i < 4; i++) {
            if (sides[i] + currentMatch <= target) {
                sides[i] += currentMatch;
                if (dfs(matchsticks, index - 1, sides, target)) {
                    return true;
                }
                sides[i] -= currentMatch;
            }
            
            if (sides[i] == 0) {
                break;
            }
        }
        
        return false;
    }
}