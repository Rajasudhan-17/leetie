// ──────────────────────────────────────────────────
// Problem  : 278. First Bad Version
// Difficulty: Easy
// Tags     : Binary Search, Interactive
// Link     : https://leetcode.com/problems/first-bad-version/
// Runtime  : 13 ms (beats 100%)
// Memory   : 42248000 (beats 17%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        
        while (left < right) {
            // Use left + (right - left) / 2 to prevent integer overflow
            int mid = left + (right - left) / 2;
            
            if (isBadVersion(mid)) {
                // The first bad version is at mid or earlier
                right = mid;
            } else {
                // The first bad version is strictly after mid
                left = mid + 1;
            }
        }
        
        // left and right converge to the first bad version
        return left;
    }
}