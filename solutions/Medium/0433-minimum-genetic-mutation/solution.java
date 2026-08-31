// ──────────────────────────────────────────────────
// Problem  : 433. Minimum Genetic Mutation
// Difficulty: Medium
// Tags     : Hash Table, String, Breadth-First Search, Bidirectional Search
// Link     : https://leetcode.com/problems/minimum-genetic-mutation/
// Runtime  : 1 ms (beats 90%)
// Memory   : 42840000 (beats 45%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> validGenes = new HashSet<>(Arrays.asList(bank));
        
        if (!validGenes.contains(endGene)) {
            return -1;
        }

        char[] choices = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(startGene);
        visited.add(startGene);

        int mutations = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                if (current.equals(endGene)) {
                    return mutations;
                }

                char[] currArray = current.toCharArray();
                
                for (int j = 0; j < 8; j++) {
                    char originalChar = currArray[j];
                    
                    for (char c : choices) {
                        if (c == originalChar) continue;
                        currArray[j] = c;
                        String nextGene = new String(currArray);

                        if (validGenes.contains(nextGene) && !visited.contains(nextGene)) {
                            queue.offer(nextGene);
                            visited.add(nextGene);
                        }
                    }
                    currArray[j] = originalChar; 
                }
            }
            mutations++;
        }

        return -1;
    }
}