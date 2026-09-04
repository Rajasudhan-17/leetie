// ──────────────────────────────────────────────────
// Problem  : 2024. Maximize the Confusion of an Exam
// Difficulty: Medium
// Tags     : String, Binary Search, Sliding Window, Prefix Sum
// Link     : https://leetcode.com/problems/maximize-the-confusion-of-an-exam/
// Runtime  : 15 ms (beats 47%)
// Memory   : 46568000 (beats 32%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
      
            int a= check('F',answerKey,k);
    int b=  check('T',answerKey,k);
     return (int)Math.max(a,b);


       
    }
    public static int check(char ch,String answerKey, int k){
        int l=0;
        int r=0;
        int maxc=0;
        int tc=0;
        for(r=0;r<answerKey.length();r++){
            if(answerKey.charAt(r)==ch)
             tc++;
             while(tc>k){
                if(answerKey.charAt(l)==ch)
                 tc--;
                 l++;
             }
             maxc=(int)Math.max(maxc,r-l+1);
        }
        return maxc;
    }
}