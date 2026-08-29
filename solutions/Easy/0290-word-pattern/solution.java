// ──────────────────────────────────────────────────
// Problem  : 290. Word Pattern
// Difficulty: Easy
// Tags     : Hash Table, String
// Link     : https://leetcode.com/problems/word-pattern/
// Runtime  : 2 ms (beats 12%)
// Memory   : 43000000 (beats 18%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        String[] words=s.split("\\s+");
        if(pattern.length()!=words.length){
            return false;
        }
        HashMap<Character, String> map1 = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();

        for(int i=0;i<pattern.length();i++){
            char c=pattern.charAt(i);
            String w = words[i];
        
        if(map1.containsKey(c) && !map1.get(c).equals(w)){
            return false;
        }

        if(map2.containsKey(w) && map2.get(w)!=c){
            return false;
        }
        map1.put(c, w);
        map2.put(w, c);
        }
        return true;
    }
}