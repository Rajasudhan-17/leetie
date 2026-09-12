// ──────────────────────────────────────────────────
// Problem  : 950. Reveal Cards In Increasing Order
// Difficulty: Medium
// Tags     : Array, Queue, Sorting, Simulation
// Link     : https://leetcode.com/problems/reveal-cards-in-increasing-order/
// Runtime  : 8 ms (beats 21%)
// Memory   : 45716000 (beats 60%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        
        int n = deck.length;
        int[] result = new int[n];
        Deque<Integer> indices = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            indices.add(i);
        }
        
        for (int card : deck) {
            int idx = indices.poll(); 
            result[idx] = card; 
            if (!indices.isEmpty()) {
                indices.add(indices.poll());
            }
        }
        
        return result;
    }
}