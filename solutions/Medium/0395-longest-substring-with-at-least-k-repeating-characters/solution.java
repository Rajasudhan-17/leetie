// ──────────────────────────────────────────────────
// Problem  : 395. Longest Substring with At Least K Repeating Characters
// Difficulty: Medium
// Tags     : Hash Table, String, Divide and Conquer, Sliding Window
// Link     : https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
// Runtime  : 6 ms (beats 63%)
// Memory   : 42728000 (beats 80%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int longestSubstring(String s, int k) {

        int longestLen = 0;
        int n = s.length();

        for(int targetUniqueChars = 1; targetUniqueChars <= 26; targetUniqueChars++) {

            int[] charFreq = new int[26];

            int uniqueChars = 0;
            int charsMeetingKFreq = 0;

            int left = 0, right = 0;

            while(right < n) {

                char currChar = s.charAt(right);

                if(charFreq[currChar - 'a'] == 0)
                    uniqueChars++;

                if(charFreq[currChar - 'a'] == k - 1)
                    charsMeetingKFreq++;

                charFreq[currChar - 'a']++;

                while(uniqueChars > targetUniqueChars) {

                    char leftChar = s.charAt(left);

                    if(charFreq[leftChar - 'a'] == 1)
                        uniqueChars--;

                    if(charFreq[leftChar - 'a'] == k)
                        charsMeetingKFreq--;

                    charFreq[leftChar - 'a']--;
                    left++;
                }

                if(uniqueChars == targetUniqueChars &&
                   charsMeetingKFreq == uniqueChars) {

                    longestLen = Math.max(longestLen, right - left + 1);
                }

                right++;
            }
        }

        return longestLen;
    }
}