// ──────────────────────────────────────────────────
// Problem  : 497. Random Point in Non-overlapping Rectangles
// Difficulty: Medium
// Tags     : Array, Math, Binary Search, Reservoir Sampling, Prefix Sum, Ordered Set, Randomized
// Link     : https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/
// Runtime  : 45 ms (beats 99%)
// Memory   : 52140000 (beats 77%)
// Language : java
// Copyright: (c) 2026 Rajasudhan-17. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;
import java.util.Random;

class Solution {
    private final int[][] rects;
    private final long[] prefix;
    private final long totalPoints;
    private final Random rand;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.prefix = new long[rects.length];
        this.rand = new Random();
        long sum = 0;
        for (int i = 0; i < rects.length; i++) {
            long width = (long) rects[i][2] - rects[i][0] + 1;
            long height = (long) rects[i][3] - rects[i][1] + 1;
            sum += width * height;
            prefix[i] = sum;
        }
        this.totalPoints = sum;
    }

    public int[] pick() {
        long target = (long) (rand.nextDouble() * totalPoints);
        int idx = Arrays.binarySearch(prefix, target);
        if (idx < 0) {
            idx = -idx - 1;
        } else {
            idx++;
        }
        int[] r = rects[idx];
        long prev = idx == 0 ? 0 : prefix[idx - 1];
        long offset = target - prev;
        long width = (long) r[2] - r[0] + 1;
        int x = r[0] + (int) (offset % width);
        int y = r[1] + (int) (offset / width);
        return new int[]{x, y};
    }
}