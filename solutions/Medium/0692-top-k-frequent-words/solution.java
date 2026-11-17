// ──────────────────────────────────────────────────
// Problem  : 692. Top K Frequent Words
// Difficulty: Medium
// Tags     : Array, Hash Table, String, Trie, Sorting, Heap (Priority Queue), Bucket Sort, Counting
// Link     : https://leetcode.com/problems/top-k-frequent-words/
// Runtime  : 8 ms (beats 66%)
// Memory   : 46304000 (beats 52%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> minHeap = new PriorityQueue<>((w1, w2) -> {
            int freq1 = count.get(w1);
            int freq2 = count.get(w2);
            if (freq1 != freq2) {
                return freq1 - freq2;
            }
            return w2.compareTo(w1);
        });

        for (String word : count.keySet()) {
            minHeap.offer(word);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        Collections.reverse(result);
        return result;
    }
}