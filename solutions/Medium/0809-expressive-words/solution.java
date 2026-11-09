// ──────────────────────────────────────────────────
// Problem  : 809. Expressive Words
// Difficulty: Medium
// Tags     : Array, Two Pointers, String
// Link     : https://leetcode.com/problems/expressive-words/
// Runtime  : 6 ms (beats 23%)
// Memory   : 44496000 (beats 9%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int expressiveWords(String s, String[] words) {
        List<int[]> sGroups = getGroups(s);
        int ans = 0;

        for (String word : words) {
            List<int[]> wGroups = getGroups(word);
            if (sGroups.size() != wGroups.size()) {
                continue;
            }

            boolean match = true;
            for (int i = 0; i < sGroups.size(); i++) {
                int[] sg = sGroups.get(i);
                int[] wg = wGroups.get(i);

                if (sg[0] != wg[0] || wg[1] > sg[1]) {
                    match = false;
                    break;
                }
                if (sg[1] > wg[1] && sg[1] < 3) {
                    match = false;
                    break;
                }
            }

            if (match) {
                ans++;
            }
        }

        return ans;
    }

    private List<int[]> getGroups(String word) {
        List<int[]> groups = new ArrayList<>();
        int n = word.length();
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && word.charAt(j) == word.charAt(i)) {
                j++;
            }
            groups.add(new int[] { word.charAt(i) - 'a', j - i });
            i = j;
        }
        return groups;
    }
}