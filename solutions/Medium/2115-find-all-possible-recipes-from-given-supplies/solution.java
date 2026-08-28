// ──────────────────────────────────────────────────
// Problem  : 2115. Find All Possible Recipes from Given Supplies
// Difficulty: Medium
// Tags     : Array, Hash Table, String, Graph Theory, Topological Sort, Directed Acyclic Graph
// Link     : https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/
// Runtime  : 59 ms (beats 66%)
// Memory   : 49304000 (beats 26%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        
        // Build the graph and in-degree map
        for (int i = 0; i < recipes.length; i++) {
            for (String ing : ingredients.get(i)) {
                graph.computeIfAbsent(ing, k -> new ArrayList<>()).add(recipes[i]);
            }
            inDegree.put(recipes[i], ingredients.get(i).size());
        }
        
        // Initialize the queue with available supplies
        Queue<String> queue = new LinkedList<>();
        for (String supply : supplies) {
            queue.offer(supply);
        }
        
        List<String> ans = new ArrayList<>();
        
        // Process using Topological Sort (Kahn's Algorithm)
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            
            if (graph.containsKey(curr)) {
                for (String dependentRecipe : graph.get(curr)) {
                    inDegree.put(dependentRecipe, inDegree.get(dependentRecipe) - 1);
                    // If all ingredients are available, we can make this recipe
                    if (inDegree.get(dependentRecipe) == 0) {
                        queue.offer(dependentRecipe);
                        ans.add(dependentRecipe);
                    }
                }
            }
        }
        
        return ans;
    }
}