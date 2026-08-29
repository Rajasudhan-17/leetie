// ──────────────────────────────────────────────────
// Problem  : 1431. Kids With the Greatest Number of Candies
// Difficulty: Easy
// Tags     : Array
// Link     : https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
// Runtime  : 1 ms (beats 97%)
// Memory   : 43496000 (beats 98%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        for (int candy : candies) {
            maxCandies = Math.max(maxCandies, candy);
        }
        
        List<Boolean> result = new ArrayList<>();
        
        for (int candy : candies) {
            if (candy + extraCandies >= maxCandies) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        
        return result;
    }
}